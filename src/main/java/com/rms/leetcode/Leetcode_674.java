package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/20
 * @email maosongran@gmail.com
 */
public class Leetcode_674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = 0, i =0, j=1, n = nums.length;
        while (j < n) {
            if (nums[j] <= nums[j-1]) {
                max = max > (j - i) ? max : (j-i);
                i = j;
            }
            ++j;
        }

        return max > (j - i) ? max : (j-i);;
    }
}
