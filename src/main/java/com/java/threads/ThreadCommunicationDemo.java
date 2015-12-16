package com.java.threads;

public class ThreadCommunicationDemo {

	public static void main(String[] args) {
		ChatApplication ca = new ChatApplication();
		new CustomerThread(ca).start();
		new ServiceProviderThread(ca).start();

	}

}
