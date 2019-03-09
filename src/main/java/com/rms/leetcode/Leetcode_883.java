package com.rms.leetcode;

public class Leetcode_883 {
    public int projectionArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[m], cols = new int[n];
        int res = 0;
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                if (grid[i][j] > rows[i])
                    rows[i] = grid[i][j];
                if (grid[i][j] > cols[j])
                    cols[j] = grid[i][j];

                if (grid[i][j] != 0)
                    ++res;
            }
        }

//        int res = m * n;
        for (int num : cols)
            res += num;
        for (int num : rows)
            res += num;
        return  res;
    }
}
