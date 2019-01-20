package com.rms.leetcode;

import java.util.Arrays;

/**
 * @author Maosong Ran
 * @date 2019/01/18
 * @email maosongran@gmail.com
 */
public class Leetcode_521 {
    public int findLUSlength(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        if (n1 == n2) {
            return a.equals(b) ? -1 : a.length();

        } else {
            return n1 > n2 ? n1 : n2;
        }
    }

    int[] prefix;
    private boolean kmp(String str, String pattern) {
        next(pattern);
        int j=0;
        for (int i=0; i < str.length();) {
            if (str.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
                if (j == pattern.length())
                    return true;
            } else {
                if (prefix[j] == -1) {
                    ++i;
                    ++j;
                } else {
                    j = prefix[j];
                }
            }
        }

        return false;
    }

    private void next(String pattern) {
        prefix = new int[pattern.length()];
        prefix[0] = -1;
        prefix[1] = 0;
        int i=0, j =1;
        while (j < pattern.length()-1) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                prefix[j+1] = ++i;
                ++j;
            } else {
                if (i == 0) {
                    ++i;
                    ++j;
                } else {
                    i = prefix[j];
                }
            }
        }
//        System.out.println(Arrays.toString(prefix));
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_521().findLUSlength("aaa", "aaaa"));
    }
}
