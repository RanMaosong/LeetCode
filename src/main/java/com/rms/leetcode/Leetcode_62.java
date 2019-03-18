package com.rms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_62 {
    Map<List<Integer>, Integer> map = new HashMap<>();
    public int uniquePaths(int m, int n) {
        List<Integer> k = new ArrayList<>();
        k.add(Math.min(m, n));
        k.add(Math.max(m, n));
        if (map.containsKey(k))
            return map.get(k);
        if (m == 1 && n == 1)
            return 1;
        else if (m <= 0 || n <= 0)
            return 0;
        else {
            int res = uniquePaths(m-1, n) + uniquePaths(m, n-1);
            map.put(k, res);
            return res;
        }
    }

    public int uniquePaths1(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        int[][] nums = new int[m][n];
        for (int i=0; i < m; ++i)
            nums[i][0] = 1;
        for (int i=0; i <n; ++i)
            nums[0][i] = 1;
        for (int i=1; i <m; ++i) {
            for (int j=1; j < m; ++j) {
                nums[i][j] = nums[i-1][j] + nums[i][j-1];
            }
        }

        return nums[m-1][n-1];
    }



    public static void main(String[] args) {

        System.out.println(new Leetcode_62().uniquePaths(3, 2));
    }
}
