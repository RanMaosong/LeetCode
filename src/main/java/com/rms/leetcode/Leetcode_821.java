package com.rms.leetcode;

public class Leetcode_821 {
    public int[] shortestToChar(String S, char C) {
        char[] cs = S.toCharArray();
        int n = S.length();
        int[] res = new int[n];
        int i = -1, j =0;
        while (j < n) {
            if (cs[j] == C) {
                if (i == -1) {
                    for (++i; i <= j; ++i)
                        res[i] = j - i;
                } else {
                    for (int a = i + 1; a <= j; ++a) {
                        res[a] = Math.min(Math.abs(a - i), Math.abs(j-a));
                    }
                }

                i = j;
            }
            ++j;
        }
        if (j - i != 1) {
            for (int a = i + 1; a < n; ++a) {
                res[a] = a - i;
            }
        }
        return res;
    }
}
