package com.rms.leetcode;

public class Leetcode_50 {
    public double myPow(double x, int n) {
        if (x == 1.0)
            return 1.0;
        if (n == 0)
            return 1.0;
        if (n < 0)
            return  1/ (x * myPow(x, -(n+1)));

        double res = x;
        long i = 2;
        while (i<=n) {
            res *= res;
            i <<= 1;
            if (i > n) {
                i >>>= 1;
                break;
            }
        }

        for (; i<n; ++i)
            res *= x;

        return res;

    }
    public double myPow1(double x, int n) {
        if (n == 0)
            return  1.0;
        if (n < 0)
            return  1 / (x * myPow1(x, -(n+1)));
        return n % 2 == 0 ? myPow1(x * x , n / 2) : myPow1(x * x, n / 2) * x;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_50().myPow(0.86429, 18));
//        double num = 0.86429;
//        double res = 1;
//        for (int i=0; i < 18; ++i) {
//            res *= num;
//            System.out.println((i+1) + " " + res);
//        }
//        System.out.println();
    }
}
