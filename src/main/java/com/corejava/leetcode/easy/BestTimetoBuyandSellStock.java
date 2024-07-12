package com.corejava.leetcode.easy;

import java.util.Arrays;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int prices[]={7,1,5,3,6,4};
        int val =2;
        BestTimetoBuyandSellStock bbs = new BestTimetoBuyandSellStock();
        int returnVal  = bbs.maxProfit(prices);
        System.out.println(returnVal);
        Arrays.stream(prices).forEach(System.out::println);
    }

    public int maxProfit(int[] prices) {

      //  1 <= prices.length <= 105
      //  0 <= prices[i] <= 104
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i] && profit < (prices[j] - prices[i])) {
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }
    public int maxProfitEfficient(int[] prices) {

      //  1 <= prices.length <= 105
      //  0 <= prices[i] <= 104
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if(op < pist){
                op = pist;
            }
        }
        return op;
    }
}
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104

 */