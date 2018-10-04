package com.rms.leetcode;

import java.util.HashMap;

public class LeetCode_70 {
    private HashMap<Integer, Integer> method = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        if (n < 1)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        if (method.containsKey(n)) {
            return method.get(n);
        } else {
            int tmp = climbStairs(n-1) + climbStairs(n - 2);
            method.put(n, tmp);
            return tmp;
        }
    }


    public int climbStairs2(int n) {
        // 斐波拉契数列
        int first = 0, second = 1;
        if (n == 1)
            return 1;

        for (int i=0; i < n; ++i) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }

        return second;
    }

    public static void main(String[] args) {
        LeetCode_70 leetCode = new LeetCode_70();
        System.out.println(leetCode.climbStairs2(2));
        System.out.println(leetCode.climbStairs2(3));
    }
}
