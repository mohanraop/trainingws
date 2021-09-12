package com.corejava.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InfiniteThread {
    //volatile boolean status=false;
    boolean status=false;
    public String process(){
        System.out.println("in process");
        while (!status){

        }
        System.out.println("step 2");
        while (status){

        }
        System.out.println("Bye");
        return "thank you";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService  es = Executors.newSingleThreadExecutor();
        InfiniteThread it = new InfiniteThread();

       Future<String>f = es.submit(()->it.process());
       Thread.sleep(1000);
        it.status=true;
        System.out.println("started");
        Thread.sleep(1000);
        it.status=false;

        System.out.println("completed");
        es.shutdown();
        System.out.println(f.get());
    }
}
