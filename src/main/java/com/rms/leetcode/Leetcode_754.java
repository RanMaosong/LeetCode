package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/22
 * @email maosongran@gmail.com
 */
public class Leetcode_754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int i = 1, sum = 1;
        while (sum < target) {
            sum += ++i;
        }

        if (sum == target || (sum - target) % 2 ==0)
            return i;
        if ((i+1) % 2 == 1)
            return i+1;
        else
            return i+2;
    }
}
