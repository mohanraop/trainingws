package com.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OddSquare {
    public void converMap(Stream< Integer> is,
                          Function< Integer,Integer> keyMapper,
                          Function<Integer, Integer> valueMapper){
        long startNS = System.nanoTime();
        is.peek(System.out::println)//peek is like log method
                .filter(i->i.intValue()%2==1)
                .collect(Collectors.toMap(keyMapper,valueMapper))
                .forEach((k,v)-> System.out.println(k+"->"+v));
        System.out.println("Time take in sequential process="+(System.nanoTime()-startNS));

        /*
            streams can not use multiple time. otherwise you get an exception
            is.forEach(System.out::println);

         */
    }
    public static void main(String[] args) {
        List<Integer> is = Arrays.asList(1,2,3,4,5,6);
        new OddSquare().converMap(is.stream(),i->i,i->i*i);

        Random rd = new Random();
        Stream<Integer> rs =  Stream.generate(()->rd.nextInt());
        new OddSquare().converMap(rs.limit(10),i->i,i->i*i);
        //new OddSquare().converMap(rs,i->i,i->i*i);  infinite stream


    }
}
