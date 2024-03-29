package com.corejava.interviewquestions;

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

        int val = i,sum=0,j;
        while(val>0){
              j = val%10;
            val = val/10;
            sum += (j*j*j);
        }
        System.out.println(sum);

        return temp==i;
    }
}
