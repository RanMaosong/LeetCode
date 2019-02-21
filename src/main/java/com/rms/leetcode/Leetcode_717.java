package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        for (int i=0; i < n-1; ++i) {
            if (bits[i] == 1 && i != n-2)
                ++i;
            else if (bits[i] == 1 && i == n-2)
                return false;
        }

        return true;
    }
}
