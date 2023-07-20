package com.corejava.jdk17.textBlocks;

import java.util.Arrays;

public class TextBlocks {
    public static void main(String[] args) {
        String str= "abc\n" +
                "def";
        String tb= """
                abc
                def""";
        System.out.println("str = " + str);
        System.out.println("tb = " + tb);
        System.out.println("tb == str -> " + (tb==str));
    }
}
