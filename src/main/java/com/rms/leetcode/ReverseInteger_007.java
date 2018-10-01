package com.rms.leetcode;

public class ReverseInteger_007 {
    public static void main(String[] args) {
        System.out.println(ReverseInteger_007.reverse(1534236469));
        System.out.println(1 % 3);
        System.out.println(-1 % 3);
    }

    public static  int reverse(int x) {
        int flag = (x<0)? -1: 1;
        double max = (flag==1)? 2e31-1 :2e31;
        x = Math.abs(x);
        int result = 0;
        while(x != 0) {
            if (result !=0 && (result * 10) / result != 10) {
                result = 0;
                break;
            }
            result *= 10;

            int temp = x % 10;
            x /= 10;

            if (max - result < temp) {
                result = 0;
                break;
            }
            result += temp;
//            System.out.println(result + " " + (2e31-1 - result) + " " + temp);
        }

        return result* flag;
    }
    public static  int reverse1(int x) {
        long result = 0;
        for (; x!=0; x /= 10) {
            result = result * 10 + x % 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }

        return (int)result;
    }
}
