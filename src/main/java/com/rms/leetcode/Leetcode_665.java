package com.rms.leetcode;

public class Leetcode_665 {
    public boolean checkPossibility(int[] nums) {
        int count = 0, n = nums.length;
        for (int i=1; i < n && count < 2; ++i) {
            if (nums[i] >= nums[i-1]) continue;
            if (i-2 >= 0 && nums[i] < nums[i-2])
                nums[i] = nums[i-1];
            ++count;
        }

        return count < 2;
    }

}
