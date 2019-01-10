package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/10
 * @email maosongran@gmail.com
 */
public class Leetcode_283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length, i =0, j=1;
        while (j < len) {
            if (nums[i] == 0) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    ++i;
                }
                ++j;
            } else {
                ++i;
            }
            if (i == j) {
                ++j;
            }
        }

    }
}
