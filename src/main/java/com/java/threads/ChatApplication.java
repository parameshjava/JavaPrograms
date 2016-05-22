package com.java.threads;

public class ChatApplication {
    boolean isQueAsked = false;

    public synchronized void askQuestion(String que) {
        
        if (isQueAsked) {
            try {
                wait();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(que);
        isQueAsked = true;
        notify();
    }

    public synchronized void answerQuery(String ans) {
        if (!isQueAsked) {
            try {
                wait();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(ans);
        isQueAsked = false;
        notify();
    }

}
