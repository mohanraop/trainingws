package com.corejava.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        System.out.println(stringSet.add("1"));
        stringSet.add("2");
        System.out.println(stringSet.add("1"));
        stringSet.add("3");
        stringSet.add("4");
        System.out.println(stringSet.add(null));
        System.out.println(stringSet.add(null));

        stringSet.forEach(System.out::println);
    }
}
