package com.corejava.collection;

import java.util.Arrays;
import java.util.List;

public class SequentialParallelStreams {
    public static void main(String[] args) {
        System.out.println("Available process="+Runtime.getRuntime().availableProcessors());
        List<Integer> is = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Sequential process");
        long startNS = System.currentTimeMillis();
        is.stream().forEach(i->{
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Time take in sequential process="+(System.currentTimeMillis()-startNS));
        System.out.println("Parallel process");
        startNS = System.currentTimeMillis();
        is.parallelStream().forEach(i->{
            try {
                Thread.sleep(1000);
                System.out.println(i+" "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Time take in parallel process="+(System.currentTimeMillis()-startNS));

    }
}
