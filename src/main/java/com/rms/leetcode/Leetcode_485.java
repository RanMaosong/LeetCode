package com.rms.leetcode;

public class Leetcode_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, len=0;
        for (int num : nums) {
            if (num == 0) {
                res = res > len ? res : len;
                len = 0;
            } else {
                ++len;
            }
        }
        res = res > len ? res : len;

        return res;
    }
}
