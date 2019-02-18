package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/18
 * @email maosongran@gmail.com
 */
public class Leetcode_633 {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int tmp = left * left + right * right;
            if (tmp < c)
                ++left;
            else if (tmp > c)
                --right;
            else
                return true;
        }
        return false;
    }
}
