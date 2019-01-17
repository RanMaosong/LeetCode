package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/14
 * @email maosongran@gmail.com
 */
public class Leetcode_458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1)
            return 0;
        int state = minutesToTest/minutesToDie + 1;
        int res = 1;
        while (Math.pow(state, res) < buckets) {
            ++res;
        }

        return res;

    }

//    public static void main(String[] args) {
//        System.out.println(Math.pow(1000, ));
//    }
}
