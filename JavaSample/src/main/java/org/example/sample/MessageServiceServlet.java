package org.example.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class MessageServiceServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	QueueManager queueManager;
	
	StringBuilder stringBuilder;
	

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println(uri);
		String order = uri.split("/")[1];
		System.out.println(order);
		String queueName;
		String result = null;
		
		if(order.equals("RECEIVE")) {
			queueName = uri.split("/")[2];
			Message message = receiveMessage(queueName);
			if(message == null) {			//fail
				result = "{\"Result\": \"No Message\"}";
			}else {				// success
				result = "{\"Result\": \"Ok\", \"MessageID\":\""+message.getId()+"\",\"Message\":\""+message.getMessage()+"\"}";
			}
			res.getWriter().write(result);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String uri = req.getRequestURI();
		System.out.println(uri);
		String order = uri.split("/")[1];
		System.out.println(order);
		String queueName;
		String messageId;
		
		String result = null;							// response
		
		if(order.equals("CREATE")) {
			queueName = uri.split("/")[2];
			
			// ���� ����
			if(createQueue(queueName,req)) {		// ����
				result = "{\"Result\": \"Ok\"}";
				resp.setStatus(200);
				resp.getWriter().write(result);
			}else {
				result = "{\"Result\": \"Queue Exist\"}";
				resp.setStatus(200);
				resp.setHeader("", "");
				resp.getWriter().write(result);
			}
			

		}else if(order.equals("SEND")) {
			queueName = uri.split("/")[2];
			// ���� ����
			if(sendMessage(queueName,req)) {		// ����
				result = "{\"Result\": \"Ok\"}";
				resp.setStatus(200);
				resp.getWriter().write(result);
			}else {
				result = "{\"Result\": \"Queue Full\"}";
				resp.setStatus(200);
				resp.getWriter().write(result);
			}
		}else if(order.equals("ACK")) {			// ack
			queueName = uri.split("/")[2];
			messageId = uri.split("/")[3];
			ackHandler(queueName,messageId);
			result = "{\"Result\": \"Ok\"}";
			resp.setStatus(200);
			resp.getWriter().write(result);
		}else if(order.equals("FAIL")) {		// consumer fail
			queueName = uri.split("/")[2];
			messageId = uri.split("/")[3];
			if(failBackMessage(queueName,messageId)) {
				result = "{\"Result\": \"Ok\"}";
			}
			resp.setStatus(200);
			resp.getWriter().write(result);
		}
	}
	
	private boolean createQueue(String queueName, HttpServletRequest request) {
		String queueSize = null;
		String body = null;
		Gson gson = new Gson();
		
		BufferedReader bufferedReader = null;
		
		StringBuilder stringBuilder = new StringBuilder();
		
		InputStream inputStream;
		try {
			// body ����
			inputStream = request.getInputStream();
			if(inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
			}
			body = stringBuilder.toString();
			
			RequestBody requestBody = gson.fromJson(body, RequestBody.class);
			
			queueSize = requestBody.getQueueSize();
			
			if(MessageServiceServer.queueManagerMap.containsKey(queueName)) {			// ������ queue �̸��� �����ϴµ� �����Ϸ��� �ϴ� ���
				// to-do
				return false;
			}else {
				queueManager = new QueueManager(queueName,Integer.valueOf(queueSize));
				MessageServiceServer.queueManagerMap.put(queueName, queueManager);
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			 if (bufferedReader != null) {
				 try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         }
		}
		return false;
	}
	
	private boolean sendMessage(String queueName, HttpServletRequest request) {
		String message = null;
		String body = null;
		Gson gson = new Gson();
		
		BufferedReader bufferedReader = null;
		
		StringBuilder stringBuilder =new StringBuilder();
		
		InputStream inputStream;
		try {
			// body ����
			inputStream = request.getInputStream();
			if(inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
			}
			body = stringBuilder.toString();
			
			RequestBody requestBody = gson.fromJson(body, RequestBody.class);
			
			message = requestBody.getMessage();
			
			QueueManager queueManager = MessageServiceServer.queueManagerMap.get(queueName);
			
			if(queueManager.add(message)) {		// ����
				MessageServiceServer.queueManagerMap.put(queueName, queueManager);
				return true;
			}else {																		// queue ����
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			 if (bufferedReader != null) {
				 try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         }
		}
		return false;
	}
	
	private void ackHandler(String queueName, String messageId) {
		QueueManager queueManager = MessageServiceServer.queueManagerMap.get(queueName);
		queueManager.ackHandler(messageId);;
	}
	
	private Message receiveMessage(String queueName) {
		
		QueueManager queueManager = MessageServiceServer.queueManagerMap.get(queueName);
		Message message = queueManager.poll();
		
		if(message == null) {
			return null;
		}else {
			return message;
		}
	}
	
	private boolean failBackMessage(String queueName, String MessageId) {
		
		QueueManager queueManager = MessageServiceServer.queueManagerMap.get(queueName);
		queueManager.addFailQueue(queueManager.tmpStoreMap.get(MessageId));;
		return true;
	}
	
}
