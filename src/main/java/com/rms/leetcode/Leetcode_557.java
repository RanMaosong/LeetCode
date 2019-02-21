package com.rms.leetcode;


/**
 * @author Maosong Ran
 * @date 2019/01/23
 * @email maosongran@gmail.com
 */

public class Leetcode_557 {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
         int i=0, j=i, n = c.length;
         while (j < n) {
             while (c[i] == ' ' && i<n) {
                 ++i;
             }
             j = i;

             while (j < n && c[j] != ' ') {
                 ++j;
             }
             swap(c, i, j-1);
             i = j;
         }

        return new String(c);
    }

    private void swap(char[] c, int i, int j) {
        for (;i < j; ++i, --j) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
    }
}
