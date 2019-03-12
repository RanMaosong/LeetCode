package com.rms.leetcode;

import java.util.Arrays;

public class Leetcode_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length - 2;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i=0; i < n; ++i) {
            int l = i + 1, r = nums.length-1;
            int min2 = Integer.MAX_VALUE;
            int sum2 = 0;
            while (l < r) {
                int diff = nums[i] + nums[l] + nums[r] - target;
                if (Math.abs(diff) < min2) {
                    min2 = Math.abs(diff);
                    sum2 = nums[i] + nums[l] + nums[r];
                    System.out.println(nums[i] + " " +  nums[l] + " " + nums[r]);
                }
                if (diff > 0)
                    --r;
                else
                    ++l;
            }

            if (min2 < min) {
                sum = sum2;
                min = min2;
            }
        }

        return sum;
    }
}
