package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/12/22
 * @email maosongran@gmail.com
 */
public class LeetCode_219 {
    public static void main(String[] args) {
        int[] nums = {99, 99};
        System.out.println(new LeetCode_219().containsNearbyDuplicate(nums, 2));

    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        for (int i=0; i < len; ++i) {
            for (int j=i+1; j <= i+k && j < len; ++j)
                if (nums[i] == nums[j])
                    return true;
        }

        return false;
    }
}
