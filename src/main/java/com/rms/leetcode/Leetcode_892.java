package com.rms.leetcode;

public class Leetcode_892 {
    public int surfaceArea(int[][] grid) {
        int res = 0;
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        int m=grid.length, n = grid[0].length;
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    res += 2;
                    for (int d=0; d < 4; ++d) {
                        int r = i + dr[d], c = j + dc[d], nv=0;
                        if (0 <= r && r < m && 0 <= c && c < n)
                            nv = grid[r][c];

                        res += Math.max(grid[i][j] - nv, 0);
                    }
                }
            }
        }

        return  res;
    }
}
