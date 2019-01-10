package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/10
 * @email maosongran@gmail.com
 */
public class Leetcode_367 {
    public boolean isPerfectSquare(int num) {
        long i = 1, j = num;
        while (i < j) {
            long mid = i + (j-i) / 2;
            if (mid * mid == num)
                return true;
            else if (mid * mid > num) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return (i * i) == num;

    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_367().isPerfectSquare(808201));
    }
}
