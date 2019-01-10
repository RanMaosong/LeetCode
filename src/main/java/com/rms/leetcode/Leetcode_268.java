package com.rms.leetcode;

import java.util.Arrays;

/**
 * @author Maosong Ran
 * @date 2019/01/09
 * @email maosongran@gmail.com
 */
public class Leetcode_268 {
    public int missingNumber(int[] nums) {
        int len = nums.length + 1;
        int[] tmp = new int[len];
        for (int i=0; i < len-1; ++i) {
            tmp[nums[i]] = 1;
        }

        for (int i=0; i < len; ++i) {
            if (tmp[i] == 0)
                return i;
        }

        return -1;

    }

    public int missingNumber1(int[] nums) {
        int miss = nums.length;
        for (int i=0; i < nums.length; ++i) {
            miss ^= i ^ nums[i];
        }

        return miss;
    }

    public int missingNumber2(int[] nums) {
        int exceptedSum = nums.length * (nums.length + 1) /2;
        int sum = 0;
        for (int a : nums)
            sum += a;
        return exceptedSum - sum;
    }

    public static void main(String[] args) {
        int[] a = new int[5];
        System.out.println(Arrays.toString(a));
    }
}
