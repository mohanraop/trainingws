package com.corejava.ds;

import java.util.Arrays;

public class PivotedBinarySearch {
    public int  pivotedBinarySearch(int array[],int key,int low,int high){

        if(high<low)
            return  -1;

        int pivot =  findPivot(array,0,high);
        System.out.println("Pivot " + pivot);
        if(array[pivot]==key)
            return pivot;
        else if (array[0] <= key)
            pivot =  binarySearch(array,key,0,pivot-1);
       else
            pivot= binarySearch(array,key,pivot+1,high);
        return pivot;

    }

    public int findPivot(int arr[], int low, int high)
    {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }

    public int binarySearch(int array[],int key,int low,int high){
        if(high<low)
            return -1;

        int mid =(high+low)/2;

        if(array[mid] == key)
            return mid;
       if(key > array[mid])
           return binarySearch(array,key,mid+1,high);
       else
           return binarySearch(array,key,low,mid-1);
    }
    public static void main(String args[])
    {
        // Let us search 3 in below array
        int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int n = arr1.length;
        int key = 10;
        PivotedBinarySearch pivotedBinarySearch = new PivotedBinarySearch();
        System.out.println(
                "Index of the element is : "
                        + pivotedBinarySearch.pivotedBinarySearch(arr1,  key,0,n-1));
    }
}
