package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/22
 * @email maosongran@gmail.com
 */
public class Leetcode_747 {
    public int dominantIndex(int[] nums) {
        int index=0, max = nums[0];
        boolean flag = true;
        for (int i=1; i < nums.length; ++i) {
            if (nums[i] > max) {
                flag = nums[i] >= max * 2 ? true : false;
                max = nums[i];
                index = i;
            } else {
                flag = max >= nums[i] * 2 && flag ? true : false;
            }
        }

        return flag ? index : -1;
    }
}
