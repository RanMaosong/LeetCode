package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/16
 * @email maosongran@gmail.com
 */
public class Leetcode_463 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int h = grid.length, w = grid[0].length;
        for (int i=0; i < h; ++i) {
            for (int j=0; j < w; ++j) {
                if (grid[i][j] == 0)
                    continue;
                res += 4;
                if (i < h-1 && grid[i+1][j] == 1)
                    res -= 2;
                if (j < w-1 && grid[i][j+1] == 1)
                    res -= 2;
            }
        }

        return res;
    }
}
