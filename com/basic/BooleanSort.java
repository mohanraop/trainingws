package com.basic;

import java.util.ArrayList;
import java.util.Collections;

public class BooleanSort {
    public static void main(String[] args) {
        ArrayList<Boolean> bl = new ArrayList<>();
        bl.add(false);
        bl.add(false);
        bl.add(false);
        bl.add(true);
        bl.add(false);
        bl.add(true);
        System.out.println("before sorting");
        bl.forEach(System.out::println);
        System.out.println("after sorting");
        bl.stream().sorted().forEach(System.out::print);
        //Collections.sort(bl);
        //bl.forEach(System.out::println);

    }
}
