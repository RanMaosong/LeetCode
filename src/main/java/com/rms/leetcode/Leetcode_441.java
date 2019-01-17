package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/14
 * @email maosongran@gmail.com
 */
public class Leetcode_441 {
    public int arrangeCoins(int n) {
        int i=1;
        while (n >= i) {
            n -= (i++);
        }

        return i-1;
    }
}
