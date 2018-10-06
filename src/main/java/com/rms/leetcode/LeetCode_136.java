package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/06
 * @email maosongran@gmail.com
 */
public class LeetCode_136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        int len = nums.length;
        for (int i=0; i < len; ++i)
            result ^= nums[i];
        return result;
    }

    public static void main(String[] args) {
        LeetCode_136 leetCode = new LeetCode_136();
        System.out.println(leetCode.singleNumber(new int[]{2, 2, 1}));
        System.out.println(leetCode.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
