package com.java.threads;

public class ServiceProviderThread extends Thread {

    ChatApplication ca;

    String[] answers = {"A1. Please let me know more about it.",
            "A2. Ok, I will asssing the ticket to corresponding team and can fix in 3 working days",
            "A3. Your are welcome."};

    public ServiceProviderThread(ChatApplication ca) {
        this.ca = ca;
    }

    @Override
    public void run() {
        for (String ans : answers) {
            ca.answerQuery(ans);
        }
    }

}
