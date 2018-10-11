package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/07
 * @email maosongran@gmail.com
 */
public class LeetCode_172 {
    public int trailingZeroes(int n) {
        /**
         * 理论可行，实际不行，溢出
         */
        int count = 0;
        long factorial =1;
        for (int i =0; ; ++i) {
            int left = i + 1;
            int right = n - i;
            if (left > right) {
                break;
            } else if (left == right) {
                factorial *= left;

            } else {
                factorial *= (left * right);
            }
            while (factorial % 10 == 0) {
                ++count;
                factorial /= 10;
            }
        }
        System.out.println("factorial=" + factorial);
        return count;
    }

    public int trailingZeroes2(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }

        return count;

    }

    public static void main(String[] args) {
        LeetCode_172 leetCode = new LeetCode_172();
        System.out.println(leetCode.trailingZeroes(3));
        System.out.println(leetCode.trailingZeroes(5));
        System.out.println(leetCode.trailingZeroes(16));
    }

}
