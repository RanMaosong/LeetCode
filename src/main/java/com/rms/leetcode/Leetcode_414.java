package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/11
 * @email maosongran@gmail.com
 */

public class Leetcode_414 {
    public int thirdMax(int[] nums) {
        Integer f = null, s = null, t = null;

        for (Integer num : nums) {
            if (num.equals(f) || num.equals(s) || num.equals(t))
                continue;
            if (f == null || num > f) {
                t = s;
                s = f;
                f = num;
            } else if(s == null || num > s) {
                t = s;
                s = num;
            } else if (t == null || num > t) {
                t = num;
            }
        }

        return t == null ? f : t;
    }
}
