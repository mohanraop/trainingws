package com.basic;

public class StringArrays {
    public static void main(String[] args) {
        String a[]={"a","b","c"};
        String b[] = new String[0];
        b = a;
        System.out.println(b.length);
        System.out.println(a.length);
        System.out.println(b[0]);
    }
}
