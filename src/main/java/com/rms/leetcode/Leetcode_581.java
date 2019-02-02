package com.rms.leetcode;

import java.util.Arrays;

public class Leetcode_581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] nums1 = Arrays.copyOf(nums, n);
        Arrays.sort(nums1);
        int i=0, j = n-1;
        while (i < n) {
            if (nums[i] != nums1[i])
                break;
            ++i;
        }

        if (i == n)
            return 0;
        while (j > 0) {
            if (nums[j] != nums1[j])
                break;
            --j;
        }

        return j - i + 1;
    }
}
