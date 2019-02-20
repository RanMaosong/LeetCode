package com.rms.leetcode;

public class Leetcode_598 {
    public int maxCount(int m, int n, int[][] ops) {
        int i=m, j = n;
        for (int[] op : ops) {
            i = i < op[0] ? i : op[0];
            j = j < op[1] ? j : op[1];
        }

        return i * j;
    }
}
