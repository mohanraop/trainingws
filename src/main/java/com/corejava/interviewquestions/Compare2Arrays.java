package com.corejava.interviewquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Compare2Arrays {
    public static void main(String[] args) {
        int a[]={12,12,12,12};
        int b[]={12,12,12,12};
        System.out.println(check(a,b,4));
        int c[]={12,1,2,21};
        int d[]={2,1,1,12};
        System.out.println(check(c,d,4));
    }
    public static boolean check2(long A[],long B[],int N)
    {
        //using a HashMap to store frequency of elements.
        HashMap<Long, Long> hm = new HashMap<Long, Long>();

        //incrementing frequencies of elements present in first array in HashMap.
        for(int i = 0;  i< N; i++)
        {
            long num = A[i];
            if(hm.containsKey(num))
            {
                long freq = hm.get(num);
                freq++;
                hm.put(num, freq);
            }
            else{
                hm.put(num, (long)1);
            }
        }
        //decrementing frequencies of elements present in
        //second array in the HashMap.
        for(int i = 0; i < N; i++)
        {
            long num = B[i];
            if(hm.containsKey(num))
            {
                long freq = hm.get(num);
                freq--;
                hm.put(num, freq);
            }
        }

        //iterating over the HashMap.
        for(Map.Entry<Long, Long> entry: hm.entrySet())
        {
            //if frequency of any element in HashMap now is not zero it means
            //that its count in two arrays was not equal so arrays aren't equal.
            if(entry.getValue() != 0)
            {
                //returning false since arrays are not equal.
                return false;
            }
        }
        //returning true if arrays are equal.
        return true;
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
