package com.rms.leetcode;

import java.util.Map;

public class Leetcode_661 {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length, col = M[0].length;
        int[][] res = new int[row][col];
        for (int i=0; i <row; ++i) {
            for (int j=0; j < col; ++j) {
                int count = 0, sum = 0;
                for (int ii = Math.max(0, i-1); ii <= Math.min(row-1, i+1); ++ii) {
                    for (int jj=Math.max(0, j-1); jj <= Math.min(col-1, j+1); ++jj) {
                        sum += M[ii][jj];
                        ++count;
                    }
                }

                res[i][j] = sum / count;
            }
        }

        return  res;

    }
}
