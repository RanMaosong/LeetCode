package com.rms.leetcode;

import java.util.Arrays;

/**
 * @author Maosong Ran
 * @date 2019/01/14
 * @email maosongran@gmail.com
 */
public class Leetcode_453 {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i=1; i < nums.length; ++i) {
            res += (nums[i] - nums[0]);
        }

        return res;
    }
}
