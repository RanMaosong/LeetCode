package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/08
 * @email maosongran@gmail.com
 */
public class LeetCode_202 {
    public boolean isHappy(int n) {
        if (n==0)
            return false;
        if ( n == 1)
            return true;
        if (n == 4)
            return false;
        int result = 0;
        while (n > 0) {
            result += Math.pow(n%10, 2);
            n /= 10;
        }

        return isHappy(result);
    }
}
