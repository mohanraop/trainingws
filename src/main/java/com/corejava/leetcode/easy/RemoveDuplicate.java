package com.corejava.leetcode.easy;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        /*int nums[]={3,2,2,3};
        int val =3;*/
        /*int nums[]={3,2,2,3};
        int val =2;*/
        int nums[]={0,1,2,2,3,0,4,2};
        int val =2;
        RemoveDuplicate duplicate = new RemoveDuplicate();
        int returnVal  = duplicate.removeElement(nums, val);
        System.out.println(returnVal);
        Arrays.stream(nums).forEach(System.out::println);
    }
    public int removeElement(int[] nums, int val) {

        //0 <= nums.length <= 100
        //0 <= nums[i] <= 50
        //0 <= val <= 100
        if(nums.length < 0 || nums.length > 100)
            return 0;
        if(val<0 || val > 100)
            return 0;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
