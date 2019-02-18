package com.rms.leetcode;

import java.util.Arrays;

/**
 * @author Maosong Ran
 * @date 2019/02/18
 * @email maosongran@gmail.com
 */
public class Leetcode_628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max1 = nums[0] * nums[1] * nums[n-1];
        int max2 = nums[n-1] * nums[n-2] * nums[n-3];

        return max1 > max2 ? max1 : max2;
    }
}
