package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0, n = nums.length;
        for (int i=0; i < n; ++i) {
            sum -= nums[i];
            if (left == sum)
                return i;
            left += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_724().pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));
    }
}
