package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/06
 * @email maosongran@gmail.com
 */
public class LeetCode_167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int len = numbers.length;
        for (int i=0; i < len - 1; ++i) {
            for (int j=i+1; j < len; ++j) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i+1;
                    result[1] = j+1;
                    return result;
                }
            }
        }
        return null;
    }
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                --right;
            } else {
                ++left;
            }
        }

        return null;
    }
}
