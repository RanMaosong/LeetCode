package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/05
 * @email maosongran@gmail.com
 */
public class LeetCode_125 {
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while (i < j) {
            char a = s.charAt(i), b = s.charAt(j);
            if (Character.isLetterOrDigit(a) && Character.isLetterOrDigit(b)) {
                if (Character.toLowerCase(a) == Character.toLowerCase(b)) {
                    ++i;
                    --j;
                } else {
                    return false;
                }
            }
            if (!Character.isLetterOrDigit(a))
                i++;
            if (!Character.isLetterOrDigit(b))
                --j;
        }

        return true;
    }
}
