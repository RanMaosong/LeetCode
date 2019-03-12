package com.rms.leetcode;


import java.util.HashMap;
import java.util.Map;

public class Leetcode_883 {
    public int projectionArea(int[][] grid) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int res = 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                int count = map1.getOrDefault(i, 0);
                count = count > grid[i][j] ? count : grid[i][j];
                map1.put(i, count);

                count = map2.getOrDefault(j, 0);
                count = count > grid[i][j] ? count : grid[i][j];
                map2.put(j, count);
                ++res;
            }
        }


        for (int key : map1.keySet()) {
            res += map1.get(key);
        }

        for (int key : map2.keySet()) {
            res += map2.get(key);
        }

        return res;
    }
}
//public class Leetcode_883 {
//    public int projectionArea(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        int[] rows = new int[m], cols = new int[n];
//        int res = 0;
//        for (int i=0; i < m; ++i) {
//            for (int j=0; j < n; ++j) {
//                if (grid[i][j] > rows[i])
//                    rows[i] = grid[i][j];
//                if (grid[i][j] > cols[j])
//                    cols[j] = grid[i][j];
//
//                if (grid[i][j] != 0)
//                    ++res;
//            }
//        }
//
////        int res = m * n;
//        for (int num : cols)
//            res += num;
//        for (int num : rows)
//            res += num;
//        return  res;
//    }
//}
