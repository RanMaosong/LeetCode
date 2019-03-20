package com.rms.leetcode;

import java.util.Arrays;

public class Leetcode_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return  0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] nums = new int[m][n];
        for (int i=0; i <m; ++i) {
            for (int j=0; j < n; ++j) {
                if (obstacleGrid[i][j] == 0) {
                    if (i != 0 && j != 0)
                        nums[i][j] = nums[i-1][j] + nums[i][j-1];
                    else if (i == 0 && (j == 0 || nums[i][j-1] != 0) && obstacleGrid[i][j] == 0)
                        nums[i][j] = 1;
                    else if (j == 0 && (i == 0 || nums[i-1][j] != 0) && obstacleGrid[i][j] == 0)
                        nums[i][j] = 1;
                    else
                        nums[i][j] = 0;
                } else {
                    nums[i][j] = 0;
                }
            }
        }
        for (int[] row : nums)
            System.out.println(Arrays.toString(row));
        return nums[m-1][n-1];
    }

    public static void main(String[] args) {
        new Leetcode_63().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});

    }
}
