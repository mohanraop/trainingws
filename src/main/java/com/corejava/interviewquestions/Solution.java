package com.corejava.interviewquestions;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxArray(array));
        System.out.println(subArray(new int[]{1,2,3}));
    }
}
