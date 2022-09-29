package com.corejava.interviewquestions;

import java.util.ArrayList;
import java.util.List;
/*
Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and return its sum and print the subarray.

Examples:

Example 1:

Input: arr = [-2,1,-3,4,-1,2,1,-5,4]

Output: 6

Explanation: [4,-1,2,1] has the largest sum = 6.

Examples 2:

Input: arr = [1]

Output: 1

Explanation: Array has only one element and which is giving positive sum of 1.
 */
public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxArray(array));
        int[] array_ = {1};
        System.out.println(maxArray(array_));
        System.out.println(subArray(new int[]{1,2,3}));
    }
    public static int maxArray(int[] nums){
        if(nums.length==0)
            return 0;
        if (nums.length==1){
            return nums[0];
        }
        int maxVal =  Integer.MIN_VALUE;
        for(int oIndex=0; oIndex<nums.length;oIndex++){
            int sum = 0;
            for (int iIndex = oIndex ; iIndex<nums.length;iIndex++){
                sum += nums[iIndex];
                if(sum>maxVal){
                    maxVal = sum;
                }
            }
        }
        //System.out.println("nums = " + re);
        return maxVal;
    }

    public static List<List<Integer>> subArray(int[] nums){
        List<List<Integer>> result =  new ArrayList<>();
        if(nums.length==0)
            return result;
        result.add(new ArrayList<>());
        List<Integer> empList =  new ArrayList<>();
        if (nums.length==1){
            empList.add(nums[0]);
            result.add(empList);
            return result;
        }

        for(int index=0 ; index<nums.length;index++){
            empList =  new ArrayList<>();
            empList.add(nums[index]);
            result.add(empList);
            for(int iIndex = index+1; iIndex<nums.length;iIndex++ ){
                empList =  new ArrayList<>();
                empList.add(nums[index]);
                empList.add(nums[iIndex]);
                result.add(empList);
            }
        }
        //result.add(Arrays.asList(nums).)
      //  System.out.println("nums = " + result);
        return result;
    }

}
