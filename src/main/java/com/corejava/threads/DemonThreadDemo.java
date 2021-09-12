package com.corejava.threads;

public class DemonThreadDemo {
    public static void main(String[] args) {
        DemonThreadDemo dt = new DemonThreadDemo();
        Thread t1 = new Thread(()->{
            System.out.println("Started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("completed");
        });
        System.out.println();
        t1.setDaemon(true);
        t1.start();
        System.out.println("bye");

    }
}
