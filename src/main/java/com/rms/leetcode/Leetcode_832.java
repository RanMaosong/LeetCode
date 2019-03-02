package com.rms.leetcode;

public class Leetcode_832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i=0; i < A.length; ++i) {
            int m = 0, n = A[0].length - 1;
            while (m <= n) {
                int tmp = A[i][m];
                A[i][m] = 1 - A[i][n];
                A[i][n] = 1 - tmp;
                ++m;
                --n;
            }
        }

        return  A;
    }
}
