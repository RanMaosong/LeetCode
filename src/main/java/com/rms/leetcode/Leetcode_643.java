package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/18
 * @email maosongran@gmail.com
 */
public class Leetcode_643 {
    public double findMaxAverage(int[] nums, int k) {
        double res = 0;
        for (int i=0; i < k; ++i) {
            res += nums[i];
        }
        double tmp = res;
        int i=0, j = k, n = nums.length;
        while (j < n) {
            tmp += (nums[j] - nums[i]);
            res = res > tmp ? res : tmp;
            ++i;
             ++j;
        }
        return res / k;

    }
}
