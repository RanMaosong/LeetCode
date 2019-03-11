package com.rms.leetcode;

public class Leetcode_806 {
    public int[] numberOfLines(int[] widths, String S) {
        int res = 0;
        int num = 0;
        for (char c : S.toCharArray()) {
            num += widths[c - 97];
            if (num > 100) {
                ++res;
                num = widths[c - 97];
            }
        }

        if (num != 0)
            ++res;
        return new int[]{res, num};
    }
}
