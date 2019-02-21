package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_709 {
    public String toLowerCase(String str) {
        char[] c = str.toCharArray();
        int n = c.length;
        for (int i=0; i < n; ++i) {
            if (c[i] >= 65 && c[i] <= 90) {
                c[i] = (char) (c[i] + 32);
            }
        }

        return new String(c);
    }
}
