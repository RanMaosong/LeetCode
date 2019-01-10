package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/10
 * @email maosongran@gmail.com
 */
public class Leetcode_344 {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int i=0, j = c.length-1;
        for (; i < j; ++i, --j) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }

        return new String(c);
    }
}
