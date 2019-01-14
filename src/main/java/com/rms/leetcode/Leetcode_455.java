package com.rms.leetcode;

import java.util.Arrays;

/**
 * @author Maosong Ran
 * @date 2019/01/14
 * @email maosongran@gmail.com
 */
public class Leetcode_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res=0, i=0, j=0, len1 = g.length, len2 = s.length;
        while (i < len1 && j < len2) {
            if (g[i] <= s[j]) {
                ++i;
                ++j;
                ++res;
            } else {
                ++j;
            }
        }

        return res;
    }
}
