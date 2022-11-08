package com.corejava.interviewquestions;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int a[]= {1, 3, 5, 7, 7, 9 };
        int b[]= {2, 4, 6, 7};
        int c[]= {11};
        int size=a.length+b.length+c.length;
        int finalArray[]= new int[size];
        int max=Integer.MAX_VALUE;

        int i=0,j=0,k=0,preVal=0,m=0,n=0,o=0,l=0;
        while(i<size&& j<size && l<size && k<size){
            if(i<a.length){
                m=a[i];
            }else{
                m =max;
            }
            if(j<b.length){
                n=b[j];
            }else{
                n =max;
            }
            if(k<c.length){
                o=c[k];
            }else{
                o =max;
            }
            if(m==n && n==o && o==max)
                break;
            int val = Math.min(Math.min(m,n),o);
            if(val > preVal){
                preVal=val;
                finalArray[l++]=val;
            }
            if(val == m){
               i++;
            }

            if(val == n){
                j++;
            }

            if(val == o){
                k++;
            }
        }

        Arrays.stream(finalArray).forEach(System.out::println);
    }
}
