package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/11/02
 * @email maosongran@gmail.com
 */
public class Leetcode_217 {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        for(int i=0; i < len-1; ++i) {
            for (int j=i+1; j<len;++j) {
                if (nums[i] == nums[j])
                    return true;
            }
        }

        return false;
    }
}
