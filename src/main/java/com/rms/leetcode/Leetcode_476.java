package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/16
 * @email maosongran@gmail.com
 */
public class Leetcode_476 {
    public int findComplement(int num) {
        int i=num, m=1;
        while (i != 1) {
            i >>= 1;
            m = (m << 1) + 1;
        }

        return num ^ m;

    }
}
