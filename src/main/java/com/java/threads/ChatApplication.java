package com.java.threads;

public class ChatApplication {
	boolean isQueAsked = false;
	
	public synchronized void question(String que) {
		try {
			if(isQueAsked) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isQueAsked = true;
		System.out.println(que);
		notify();
	}
	
	public synchronized void answer(String ans) {
		if(!isQueAsked) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isQueAsked = false;
		System.out.println(ans);
		notify();
	}

}
