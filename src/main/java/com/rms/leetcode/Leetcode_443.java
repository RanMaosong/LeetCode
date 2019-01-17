package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/14
 * @email maosongran@gmail.com
 */
public class Leetcode_443 {
    public int compress(char[] chars) {
        int i=0, j=0, k=1;
        while (k < chars.length) {
            if (chars[k] != chars[j]) {
                chars[i++] = chars[j];
                if (k - j != 1) {
                    char[] num = (""+(k-j)).toCharArray();
                    for (char c : num) {
                        chars[i++] = c;
                    }
                }
                j = k;
            }
            ++k;
        }
        chars[i++] = chars[j];
        if (k - j != 1) {
            char[] num = (""+(k-j)).toCharArray();
            for (char c : num) {
                chars[i++] = c;
            }
        }

        return i;

    }
}
