package com.rms.leetcode;

import java.util.Arrays;

public class Leetcode_561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i=0; i < n; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
