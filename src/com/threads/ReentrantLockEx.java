package com.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {
    Lock lock = new ReentrantLock();
    int i=0;
    public void increment(){
        if(lock.tryLock()){
            try{
                System.out.println((++i)+"  "+Thread.currentThread().getName() );
            }finally {
                lock.unlock();
            }
        }else {
            System.out.println(Thread.currentThread().getName()+" is not acquired lock");
        }
    }


    public void lockIncrement(){
            try{
                lock.lock();
                System.out.println((++i)+"  "+Thread.currentThread().getName() );
            }finally {
                lock.unlock();
            }
        }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es= Executors.newFixedThreadPool(20);
        ReentrantLockEx rle = new ReentrantLockEx();
        for (int i=0;i<30;i++){
            if(i%2==0)
            es.execute(()->rle.increment());
            else
                es.execute(()->rle.lockIncrement());
            //es.submit(()->rle.lockIncrement()).get();
        }
        es.shutdown();
        System.out.println("Completed");
    }

}
