package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_696 {
    public int countBinarySubstrings(String s) {
        char[] c = s.toCharArray();
        int pre=0, next=1, res = 0, n = s.length();
        for (int i=1; i < n; ++i) {
            if (c[i] == c[i-1]) {
                ++next;
            } else {
                res += Math.min(pre, next);
                pre = next;
                next = 1;
            }
        }
        res += Math.min(pre, next);
        return res;
    }
}
