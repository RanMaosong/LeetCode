package com.rms.leetcode;

import java.util.Arrays;

public class Leetcode_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        operation(res, 0, n-1, n-1, 0, 1);
        return res;
    }

    private void operation(int[][] matrix, int t, int r, int b, int l, int num) {
        if (t > b || l > r)
            return;
        if (t == b) {
            while (l <= r)
                matrix[t][l++] = num++;
        } else if ( l == r) {
            while (t <= b)
                matrix[t++][l] = num++;
        } else {
            int m = matrix.length, n = matrix[0].length;
            for (int i=l; i < r; ++i)
                matrix[t][i] = num++;
            for (int i=t; i < b; ++i)
                matrix[i][r] = num++;
            for (int i=r; i > l && b > t; --i)
                matrix[b][i] = num++;
            for (int i=b; i > t && l < r; --i)
                matrix[i][l] = num++;
            operation(matrix, t+1, r-1, b-1, l+1, num);
        }

    }

    public static void main(String[] args) {
        int[][] res = new Leetcode_59().generateMatrix(3);
        for (int[] a : res)
            System.out.println(Arrays.toString(a));
    }
}
