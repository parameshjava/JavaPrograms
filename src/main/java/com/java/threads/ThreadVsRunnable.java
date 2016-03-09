package com.java.threads;

class ImplementsRunnable implements Runnable {

    private int counter = 0;
    
    private String name;
    
    public ImplementsRunnable(String name) {
        this.name = name;
    }

    public void run() {
        counter++;
        System.out.println("ImplementsRunnable : Counter : " + name + " - " + counter);
    }
}

class ExtendsThread extends Thread {

    private int counter = 0;
    
    private String name;
    
    public ExtendsThread(String name) {
        this.name = name;
    }

    public void run() {
        counter++;
        System.out.println("ExtendsThread : Counter : " + name + " - " + counter);
    }
}

public class ThreadVsRunnable {

    public static void main(String args[]) throws Exception {
        //Multiple threads share the same object.
        ImplementsRunnable rc = new ImplementsRunnable("Reaource A");
        Thread t1 = new Thread(rc);
        t1.start();
        Thread.sleep(1000); // Waiting for 1 second before starting next thread
        Thread t2 = new Thread(rc);
        t2.start();
        Thread.sleep(1000); // Waiting for 1 second before starting next thread
        Thread t3 = new Thread(rc);
        t3.start();

        //Creating new instance for every thread access.
        ExtendsThread tc1 = new ExtendsThread("Resource A");
        tc1.start();
        Thread.sleep(1000); // Waiting for 1 second before starting next thread
        ExtendsThread tc2 = new ExtendsThread("Resource B");
        tc2.start();
        Thread.sleep(1000); // Waiting for 1 second before starting next thread
        ExtendsThread tc3 = new ExtendsThread("Resource C");
        tc3.start();
    }
}
