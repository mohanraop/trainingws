package com.corejava.leetcode.easy;

import java.util.Arrays;
/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109


Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
public class MergingOfArrays {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] nums1 ={1,2,3,0,0,0};
        int[] nums2 ={4,5,6};
/*      int[] nums1 ={4,5,6,0,0,0};
        int[] nums2 ={1,2,3};*/
        /*int[] nums1 = {1, 2, 5, 0, 0, 0};
        int[] nums2 = {2, 3, 4};*/
        s.merge(nums1, 3, nums2, 3);
        Arrays.stream(nums1).forEach(System.out::println);
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp = m + n;
        if (nums1.length != temp) {
            return;
        } else if (nums2.length != n) {
            return;
        } else if (m < 0 || n < 0 || m > 200 || n > 200) {
            return;
        } else {
            if (temp < 1 || temp > 200) {
                return;
            } else if (n == 0) {
                return;
            }
            int i = 0, j = 0, k = 0;
            i = m - 1;
            j = n - 1;
            k = temp - 1;
            while (j >= 0) {
                if (i >= 0 && nums1[i] > nums2[j]) {
                    nums1[k--] = nums1[i--];
                } else {
                    nums1[k--] = nums2[j--];
                }
            }
        }
    }
}
