package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/08
 * @email maosongran@gmail.com
 */
public class LeetCode_190 {
    public int reverseBits(int n) {
        int result = 0;
        for(int i=0; i < 32; ++i) {
            int lastBit = n & 1;
            n >>= 1;
            result = (result << 1) | lastBit;
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode_190 leetCode = new LeetCode_190();
        System.out.println(leetCode.reverseBits(43261596));
    }
}
