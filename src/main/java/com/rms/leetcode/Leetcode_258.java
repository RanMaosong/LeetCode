package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/12/28
 * @email maosongran@gmail.com
 */
public class Leetcode_258 {
    public int addDigits(int num) {
        if (num >= 0 && num < 10)
            return num;
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return addDigits(result);

    }

    public int addDigits1(int num) {
        while (num > 9) {
            num = num%10 + num/10;
        }

        return num;
    }
}
