package com.rms.leetcode;

import java.util.Arrays;

/**
 * @author Maosong Ran
 * @date 2019/01/15
 * @email maosongran@gmail.com
 */
public class Leetcode_459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length(), i=len/2;
        while (i > 0) {
            if (len % i == 0) {
                char[] pa = s.substring(0, i).toCharArray();
                System.out.println(Arrays.toString(pa));
                int j=0, k;
                for (k=i; k < len; ++k, ++j) {
                    if (pa[j%pa.length] != s.charAt(k))
                        break;
                }

                if (j % pa.length == 0 && k == len)
                    return true;
            }
            --i;
        }

        return false;
    }

    // KMP
    public boolean repeatedSubstringPattern1(String s) {
        int[] next = kmp(s);
        int prefix = next[next.length-1];
        int n = s.length();
        return prefix >0 && n % (n - prefix) == 0;
    }
    private int[] kmp(String s) {
        int len = s.length();
        int[] res = new int[len];
        res[0] = 0;
        int i=0, j =1;
        while (i < len && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                res[j] = ++i;
                ++j;
            } else {
                if (i == 0) {
                    res[j] = 0;
                    ++j;
                } else {
                    i = res[i-1];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_459().repeatedSubstringPattern1("ababab"));
    }
}
