package com.rms.leetcode;

import java.util.Arrays;

/**
 * @author Maosong Ran
 * @date 2019/01/16
 * @email maosongran@gmail.com
 */
public class Leetcode_475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i=0, res = 0;
        for (int house : houses) {
            while (i < heaters.length-1 && heaters[i] + heaters[i+1] <= house*2) {
                ++i;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }

        return res;
    }

    public static void main(String[] args) {
        new Leetcode_475().findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4});
    }
}
