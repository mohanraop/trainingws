package com.corejava.threads;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class CF {
    public static void main(String[] args) {
        System.out.println("Started");
        System.out.println("Started");

        CompletableFuture
                .supplyAsync(()->200)
                .thenApply(i->i*i)
                .thenAccept(System.out::println);

        System.out.println("after apply");

        Function<Integer,Integer> fun = i->i*2;
        Consumer<Integer> con = System.out::println;
        printResult(fun,con);
        var i =  10;
        var result  = consumeResuklts(i);



    }
    private static String consumeResuklts(Integer temp){
        return "";
    }

    private static void printResult(Function<Integer, Integer> fun, Consumer<Integer> con) {
        System.out.println("fun = " + fun + ", con = " + con);
        con.accept(fun.apply(200));
    }
}

