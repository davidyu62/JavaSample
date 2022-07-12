package org.example.sample;

import java.util.HashMap;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;


public class MessageServiceServer {
	
	
	public static HashMap<String,QueueManager> queueManagerMap = new HashMap<>();
	
	public void startUp() {
		initialized();
	}
	
	// ���� �ʱ�ȭ �� �⵿
	public void initialized() {
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(8080);
		server.addConnector(http);

		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(MessageServiceServlet.class, "/");
		server.setHandler(servletHandler);

		try {
			server.start();
			System.out.println("Server Started");
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
