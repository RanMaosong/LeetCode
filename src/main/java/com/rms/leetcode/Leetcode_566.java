package com.rms.leetcode;

public class Leetcode_566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length, col = nums[0].length;
        int[][] res = new int[r][c];
        if (row * col != r * c)
            return nums;
        int m = 0, n = 0;
        for (int i=0; i < row; ++i) {
            for (int j=0; j < col; ++j) {
                res[m][n] = nums[i][j];
                ++n;
                if (n == c ) {
                    ++m;
                    n = 0;
                }
            }
        }
        return res;
    }
}
