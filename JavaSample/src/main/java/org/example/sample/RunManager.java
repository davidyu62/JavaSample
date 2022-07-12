package org.example.sample;

public class RunManager {
	
	public void start() {
		new MessageServiceServer().startUp();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RunManager().start();
	}

}
