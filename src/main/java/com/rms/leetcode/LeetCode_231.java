package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/12/22
 * @email maosongran@gmail.com
 */
public class LeetCode_231 {
    public boolean isPowerOfTwo(int n) {
        int i=0;
        while(true) {
            if (Math.pow(2, i) == n)
                return true;
            if (Math.pow(2, i) > n)
                return false;

            ++i;
        }

    }
}
