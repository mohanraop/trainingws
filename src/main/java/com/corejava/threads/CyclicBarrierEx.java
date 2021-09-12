package com.corejava.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierEx {

    public CyclicBarrierEx() {
    }

    public void execute(CyclicBarrier cb1,CyclicBarrier cb2){
        try {
            releaseAnimal();
            cb1.await();
            cleanCage();
            cb2.await();
            addingFood();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void releaseAnimal(){
        System.out.println("Animal released by  "+Thread.currentThread().getName());
    }
    private void cleanCage(){
        System.out.println("Cleaning Cage by "+ Thread.currentThread().getName());
    }
    private void addingFood(){
        System.out.println("Adding food by "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        int numOfThread =5;
        CyclicBarrierEx example = new CyclicBarrierEx();
        CyclicBarrier cb1 = new CyclicBarrier(5);
        CyclicBarrier cb2 = new CyclicBarrier(5);

        ExecutorService es = Executors.newFixedThreadPool(5);

        for (int i=0;i<10;i++){
            es.submit(()->example.execute(cb1,cb2));
        }
        System.out.println("exiting from main");

        es.shutdown();

    }
}
