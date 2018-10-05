package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/05
 * @email maosongran@gmail.com
 */
public class LeetCode_122 {
    public int maxProfit(int[] prices) {
        int profit = 0, len = prices.length;
        for (int i =0; i < len-1; ++i) {
            if (prices[i + 1] > prices[i])
                profit += (prices[i+1] - prices[i]);
        }

        return profit;
    }
}
