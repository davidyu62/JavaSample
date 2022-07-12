package org.example.sample;

public class Message {
	String message;
	String id;
	int priority;
	public Message(String message, String id, int priority) {
		super();
		this.message = message;
		this.id = id;
		this.priority = priority;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		return "Message [message=" + message + ", id=" + id + ", priority=" + priority + "]";
	}
	
}
