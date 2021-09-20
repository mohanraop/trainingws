package com.corejava.interviewquestions;

public class EvilNum{
    public static void main(String args[]){
        int i = 16;
        if(binary(i)%2==0){
            System.out.println(i+" is evil number");
        }else{
            System.out.println(i+" is not evil number");
        }
    }
    public static int binary(int i){
        int count  = 0 ;

        if(i==count)
            return i;

        for(int li=i;li>0;li=li/2){
            if(li%2!=0){
                System.out.println(li%2);
                count++;
            }
        }
        return count;
    }
}