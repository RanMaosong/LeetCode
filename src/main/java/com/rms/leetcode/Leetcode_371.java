package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/10
 * @email maosongran@gmail.com
 */
public class Leetcode_371 {
    public int getSum(int a, int b) {
        while (a != 0) {
            int jinwei = (a & b) << 1;
            b = a ^ b;
            a = jinwei;
        }

        return b;

    }
}
