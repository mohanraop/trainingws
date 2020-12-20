package com.ds.sorting;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
public interface Sortting {
    List<Integer> iList = Arrays.asList(29,19,32,17,7,10);
    // List<Integer> iList = Arrays.asList(1,2,3,4,5);
    public void sort();

    static void print(){
        iList.forEach(System.out::println);
    }

}
