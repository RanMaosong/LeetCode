package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/20
 * @email maosongran@gmail.com
 */
public class Leetcode_680 {
    boolean flag = false;
    public boolean validPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = s.length(), i =0, j = n - 1;
        while (i <= j) {
            if (c[i] == c[j]) {
                ++i;
                --j;
            } else {
                if (flag)
                    return false;
                flag = true;
                return validPalindrome(s.substring(i+1, j+1)) || validPalindrome(s.substring(i, j));

            }
        }

        return true;
    }
}
