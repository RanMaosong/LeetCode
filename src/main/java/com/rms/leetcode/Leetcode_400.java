package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/11
 * @email maosongran@gmail.com
 */
public class Leetcode_400 {
    public int findNthDigit(int n) {
        if (n < 10)
            return n;
        long i=2,c=90;
        n -= 9;
        while (n > c*i) {
            n -= c * i;
            c *= 10;
            ++i;
        }
        int start = (int) (Math.pow(10, i-1) - 1);

        int index1 = (int) ((n + i -1) / i), index2 = (int) ((n + i -1) % i);
        start += index1;
        String tmp = "" + start;


        return (int)(tmp.toCharArray()[index2] - '0');
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_400().findNthDigit(2147483647));
    }
}
