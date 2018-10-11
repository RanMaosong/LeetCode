package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/08
 * @email maosongran@gmail.com
 */
public class LeetCode_198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        else if (len == 1)
            return nums[0];
        else if (len == 2)
            return Math.max(nums[0], nums[1]);
        else {
            int[] profit = new int[]{nums[0], nums[1]} ;
            for (int i=2; i < len; ++i) {
                int tmp = nums[i] += profit[0];
                profit[0] = Math.max(profit[0], profit[1]);
                profit[1] = tmp;
            }
            return Math.max(profit[0], profit[1]);
        }
    }
    public int rob2(int[] nums) {
        int prev1 = 0, prev2 = 0;
        for(int num : nums) {
            int tmp = prev2;
            prev2 = Math.max(num + prev1, prev2);
            prev1 = tmp;
        }
        return Math.max(prev1, prev2);
    }
}
