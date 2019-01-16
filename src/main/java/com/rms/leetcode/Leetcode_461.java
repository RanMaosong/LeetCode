package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/16
 * @email maosongran@gmail.com
 */
public class Leetcode_461 {
    public int hammingDistance(int x, int y) {
        int res = 0, mask = 1, oxr = x ^ y;
        while (oxr != 0) {
            res += oxr & mask;
            oxr >>= 1;
        }

        return res;
    }
}
