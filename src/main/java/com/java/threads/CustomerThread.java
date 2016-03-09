package com.java.threads;

public class CustomerThread extends Thread {

    ChatApplication ca;

    CustomerThread(ChatApplication ca) {
        this.ca = ca;
    }

    String questions[] = {"Q1. Hi, I have problem in handset", "Q2. I cant hear properly", "Q3. Ok. Thank you."};

    @Override
    public void run() {
        for (String que : questions) {
            ca.question(que);
        }
    }

}
