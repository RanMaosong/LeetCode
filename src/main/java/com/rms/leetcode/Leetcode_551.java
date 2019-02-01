package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/23
 * @email maosongran@gmail.com
 */
public class Leetcode_551 {
    public boolean checkRecord(String s) {
        char[] cs = s.toCharArray();
        int a=0, l=0;
        for (char c : cs) {
            if (c == 'A') {
                ++a;
                if (a > 1 || l > 3)
                    return false;
                l = 0;

            }
            else if (c == 'L') {
                ++l;
                if (a > 1 || l > 2)
                    return false;
            }
            else
                l = 0;
        }
        return true;
    }
}
