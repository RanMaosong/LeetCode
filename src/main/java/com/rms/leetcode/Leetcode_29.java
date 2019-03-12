package com.rms.leetcode;

public class Leetcode_29 {
    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1)
            return 2147483647;
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long m = Math.abs((long)dividend), n=Math.abs((long)divisor);
        System.out.println(m + " " + n);
        int res = 0;
        while (m >= n) {
            long  t = n, p = 1;
            while (m >= (t << 2)) {
                p <<= 2;
                t <<= 2;
            }

            res += p;
            m -= t;
        }

        return sign == 1? res : -res;

    }

    public static void main(String[] args) {
        new Leetcode_29().divide(-1010369383, -2147483648);
    }
}
