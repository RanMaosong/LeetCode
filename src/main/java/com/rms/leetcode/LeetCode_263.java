package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/09
 * @email maosongran@gmail.com
 */
public class LeetCode_263 {
    public boolean isUgly(int num) {
        if (num <= 0)
            return false;

        while (num > 1) {
            if (num % 2 ==0)
                num /= 2;
            else if(num % 3 == 0)
                num /= 3;
            else if (num % 5 == 0)
                num /= 5;
            else
                return false;
        }
        return true;

    }
}
