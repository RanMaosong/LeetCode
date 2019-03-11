package com.rms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int a : A)
            sumA += a;
        for (int b : B) {
            sumB += b;
            set.add(b);
        }
        int[] res = new int[2];
        int delta = (sumB - sumA) / 2;
        for (int a : A) {
            if (set.contains(a + delta)) {
                res[0] = a;
                res[1] = a + delta;
                break;
            }
        }

        return res;
    }
}
