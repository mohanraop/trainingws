package com.corejava.interviewquestions;

import java.util.Arrays;

public class Compare2Arrays {
    public static void main(String[] args) {
        int a[]={12,12,12,12};
        int b[]={12,12,12,12};
        System.out.println(check(a,b,4));
        int c[]={12,1,2,21};
        int d[]={2,1,1,12};
        System.out.println(check(c,d,4));
    }
    public static boolean check(int a[],int b[],int n)
    {
        //Your code here
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                if(j+1<n ){
                    int temp=0;
                    if(a[j]>a[j+1]){
                        temp =a[j+1];
                        a[j+1] =a[j];
                        a[j]=temp;
                    }
                    temp=0;
                    if(b[j]>b[j+1]){
                        temp =b[j+1];
                        b[j+1] =b[j];
                        b[j]=temp;
                    }
                }
            }
            if(!(a[n-i-1]==b[n-i-1])){
                return false;
            }
        }
        Arrays.stream(a).forEach(System.out::print);
        System.out.println();
        Arrays.stream(b).forEach(System.out::print);
        System.out.println();
        return true;
    }
}
