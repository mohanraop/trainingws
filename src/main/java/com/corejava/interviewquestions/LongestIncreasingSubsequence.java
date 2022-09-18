package com.corejava.interviewquestions;

/* Dynamic Programming Java implementation
of LIS problem */

import java.util.Arrays;

class LongestIncreasingSubsequence {
    /* lis() returns the length of the longest
    increasing subsequence in arr[] of size n */
    static int lis1(int arr[], int n)
    {
        int lis[] = new int[n];
        int i, j, max = 0;

        /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++)
            lis[i] = 1;

		/* Compute optimized LIS values in
		bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }


    /* To make use of recursive calls, this function must
    return two things: 1) Length of LIS ending with element
    arr[n-1]. We use max_ending_here for this purpose 2)
    Overall maximum as the LIS may end with an element
       before arr[n-1] max_ref is used this purpose.
    The value of LIS of full array of size n is stored in
    *max_ref which is our final result */
    static int f(int idx, int prev_idx, int n, int a[],
                 int[][] dp)
    {
        if (idx == n) {
            return 0;
        }

        if (dp[idx][prev_idx + 1] != -1) {
            return dp[idx][prev_idx + 1];
        }

        int notTake = 0 + f(idx + 1, prev_idx, n, a, dp);
        int take = Integer.MIN_VALUE;
        if (prev_idx == -1 || a[idx] > a[prev_idx]) {
            take = 1 + f(idx + 1, idx, n, a, dp);
        }

        return dp[idx][prev_idx + 1] = Math.max(take, notTake);
    }

    // The wrapper function for _lis()
    static int lis2(int arr[], int n)
    {

        // The function _lis() stores its result in max
        int dp[][] = new int[n+1][n+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return f(0, -1, n, arr, dp);


    }

    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
       /* System.out.println("Length of lis is " + lis1(arr, n)
                + "\n");*/
        System.out.println("Length of lis is " + lis2(arr, n)
                + "\n");
    }
}