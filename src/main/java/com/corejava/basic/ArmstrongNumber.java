package com.corejava.basic;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int i=153;
        System.out.println(i +" is " + (isArmstrongNumber(i)?"a ":"not a ")+"Armstrong Number");

        i=253;
        System.out.println(i +" is " + (isArmstrongNumber(i)?"a ":"not a ")+"Armstrong Number");
    }

    private static boolean isArmstrongNumber(int i) {
        ArrayList<Integer> list = new ArrayList<>();
        int temp = i ;
        while(temp>0){
            list.add(temp%10);
            temp=temp/10;
        }
        int length=list.size();
        temp = list.stream().map(val-> {
            int no=0;
            int nval=1;
            while(no<length){
                nval *= val;
                no++;
            }
            return nval;
        }).reduce(Integer::sum).get();
        return temp==i;
    }
}
