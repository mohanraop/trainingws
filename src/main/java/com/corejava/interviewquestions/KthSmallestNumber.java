package com.corejava.interviewquestions;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestNumber {

    public static void main(String[] args) {
        int arr[] = {7,10, 4 ,20, 15};
        System.out.println(kthSmallest(arr,0,4,1));
        int arr1[] = {7,4, 4 ,20, 15};
        System.out.println(kthSmallest2(arr1,0,4,2));
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i: arr){
            q.add(i);
        }
        System.out.println(q);
        while (!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
    //ntegers l and r denoting the starting and ending index
// of the array and an integer K as input and returns the Kth smallest element.
    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        if(arr.length==0 ||  arr.length <k || k==0)
            return 0;
        int size = arr.length;
        int numItt = 0;
        for(int i=0;i<=size-k;i++){
            for(int j=0;j<size-i;j++){
                if(j+1 < size  && arr[j] >arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] =arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr[k-1];
    }

    public static int kthSmallest2(int[] arr, int l, int r, int k)
    {   int j = 0,i=0,q1=k;
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        while(q1-->0){
            q.add(arr[i]);
            i++;
        }
        i=k;
        for(i=k;i<=r;i++){
            j=q.peek();
            if(j>arr[i])
            {
                q.poll();
                q.add(arr[i]);
            }
        }
        return q.poll();
    }
}
