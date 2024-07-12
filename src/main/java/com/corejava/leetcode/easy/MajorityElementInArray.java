package com.corejava.leetcode.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


public class MajorityElementInArray {
    public static void main(String[] args) {
        int nums[]={2,2,1,1,1,2,2};
        MajorityElementInArray mea = new MajorityElementInArray();
        int returnVal  = mea.majorityElement(nums);
        System.out.println(returnVal);
        Arrays.stream(nums).forEach(System.out::println);
    }
    public int majorityElement(int[] nums) {
       /*
         1 <= n <= 5 * 104
        -109 <= nums[i] <= 109
        */
        if(nums.length == 0 || nums.length > 5 * 104)
            return 0;
        int threshold = nums.length / 2;
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(
                        num -> num,
                        num -> 1,
                        Integer::sum
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > threshold)
                .map(Map.Entry::getKey)
                .findFirst().orElseGet(()->0);
    }
}
/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */