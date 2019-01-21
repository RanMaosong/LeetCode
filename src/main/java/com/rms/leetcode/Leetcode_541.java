package com.rms.leetcode;



import java.util.Arrays;

/**
 * @author Maosong Ran
 * @date 2019/01/21
 * @email maosongran@gmail.com
 */
public class Leetcode_541 {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int i=0; i < s.length(); i += 2 * k) {
            int left, right;
            if (i + k < s.length()) {
                left = i;
                right = i + k - 1;
            } else {
                left = i;
                right = s.length() - 1;

            }
            while (left < right) {
                char tmp = c[left];
                c[left] = c[right];
                c[right] = tmp;
                ++left;
                --right;
            }
        }
        StringBuilder res = new StringBuilder();
        res.append(c);
        return res.toString();
    }
}
