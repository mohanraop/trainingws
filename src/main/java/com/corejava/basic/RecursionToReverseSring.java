package com.corejava.basic;

public class RecursionToReverseSring {

    public static void main(String[] args) {
        String  test="test";

        System.out.println(reverseString(test));
    }

    private static String reverseString(String test) {
        String result ="";
        if(test.length()>0){
            result = result+test.charAt(test.length()-1)+reverseString(test.substring(0,test.length()-1));
        }
        return  result;
    }
}
