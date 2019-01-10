package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/10
 * @email maosongran@gmail.com
 */
public class Leetcode_303 {
    int[] nums;
    public Leetcode_303(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        while (i <= j) {
            sum += nums[i++];
        }

        return sum;
    }
}
