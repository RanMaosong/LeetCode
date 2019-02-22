package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/22
 * @email maosongran@gmail.com
 */
public class Leetcode_766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;

        for (int i=0; i < r-1; ++i) {
            for (int j=0; j < c-1; ++j) {
                if (matrix[i][j] != matrix[i+1][j+1])
                    return false;
            }
        }

        return true;
    }
}
