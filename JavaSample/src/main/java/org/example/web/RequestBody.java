package org.example.web;

public class RequestBody {
	String QueueSize;
	String Message;
	
	public RequestBody(String queueSize, String message) {
		super();
		this.QueueSize = queueSize;
		this.Message = message;
	}
	
	
	
	public String getQueueSize() {
		return QueueSize;
	}



	public void setQueueSize(String queueSize) {
		this.QueueSize = queueSize;
	}



	public String getMessage() {
		return Message;
	}



	public void setMessage(String message) {
		this.Message = message;
	}



	@Override
	public String toString() {
		return "RequestBody [QueueSize=" + QueueSize + ", Message=" + Message + "]";
	}
}
