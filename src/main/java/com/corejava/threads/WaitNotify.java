package com.corejava.threads;

import java.util.concurrent.*;

public class WaitNotify {
    public synchronized void print(){
        System.out.println(Thread.currentThread().getName());
        try {
            this.notify();
            this.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        WaitNotify wf = new WaitNotify();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        Runnable task = ()->{
            wf.print();
        };
        System.out.println("scheduling task to be executed every 1 seconds with an initial delay of 0 seconds");
        for(int i=0;i<10;i++) {
            scheduledExecutorService.scheduleAtFixedRate(task, 0, 1, TimeUnit.MILLISECONDS);
            scheduledExecutorService.scheduleAtFixedRate(task, 0, 1, TimeUnit.MILLISECONDS);
        }
        System.out.println(scheduledExecutorService.isTerminated());
    }
}
