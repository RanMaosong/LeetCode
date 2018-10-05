package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/05
 * @email maosongran@gmail.com
 */
public class LeetCode_121 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int max = prices[1] - prices[0];
        int curMax = prices[1] - prices[0];

        int len = prices.length;
        for (int i = 2; i < len; ++i) {
            int tmp = prices[i] + curMax - prices[i-1];
            curMax = Math.max(tmp, prices[i] - prices[i-1]);
            max = Math.max(max, curMax);
        }

        return Math.max(max, 0);
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0)
            return 0;
        int max = 0;
        int minPrice = prices[0];
        for(int i=0; i < prices.length; ++i) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            int profit = prices[i] - minPrice;
            if (max < profit)
                max = profit;
        }

        return max;
    }


    public static void main(String[] args) {
        LeetCode_121 leetCode = new LeetCode_121();
        System.out.println(leetCode.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
