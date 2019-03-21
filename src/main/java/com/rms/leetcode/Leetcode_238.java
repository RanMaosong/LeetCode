package com.rms.leetcode;

public class Leetcode_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] l = new int[n], r = new int[n];
        l[0] = 1;
        r[n-1] = 1;
        for (int i=1; i < n; ++i) {
            l[i] = l[i-1] * nums[i-1];
            r[n-1-i] = r[n-i] * nums[n-i];
        }

        int[] res = new int[n];
        for (int i=0; i < n; ++i) {
            res[i] = l[i] * r[i];
        }

        return res;

    }

    public int[] productExceptSelf1(int[] nums) {
        int n= nums.length;
        int[] res = new int[n];
        int val = 1;
        for (int i=0; i < n; ++i) {
            res[i] = val;
            val *= nums[i];
        }

        val = 1;
        for (int i = n-1; i >= 0; --i) {
            res[i] *= val;
            val *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
