package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_693 {
    public boolean hasAlternatingBits(int n) {
        int mask = -1;
        while (n != 0) {
            int remain = n % 2;
            n /= 2;
            if (mask == remain)
                return false;
            mask = remain;
        }

        return  true;
    }
}
