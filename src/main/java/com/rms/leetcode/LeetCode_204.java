package com.rms.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Maosong Ran
 * @date 2018/10/11
 * @email maosongran@gmail.com
 */
public class LeetCode_204 {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
//        System.out.println(Arrays.toString(primes));
        int count = 0;

        for (int i = 2; i < n; ++i) {
            if (primes[i] == false) {
                ++count;
                primes[i] = true;
                int j = 1;
                while (i * j < n) {
                    primes[i * j] = true;
                    ++j;
                }
            }
        }


        return count;
    }


    public static void main(String[] args) {
        LeetCode_204 leetCode = new LeetCode_204();
        System.out.println(leetCode.countPrimes(10));
    }
}
