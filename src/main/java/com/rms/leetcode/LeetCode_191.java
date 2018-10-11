package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/08
 * @email maosongran@gmail.com
 */
public class LeetCode_191 {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i < 32; ++i) {
            int bit = (n >> i) & 1;
            if (bit == 1)
                ++count;
        }
        return count;
    }
}
