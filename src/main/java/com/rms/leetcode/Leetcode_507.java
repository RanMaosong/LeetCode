package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/18
 * @email maosongran@gmail.com
 */
public class Leetcode_507 {
    public boolean checkPerfectNumber(int num) {

        int res = 0;
        int i = num/2;
        while (i > 0 ) {
            if (num % i == 0) {
                res = res + i + num/i;
            }
            --i;
        }
        res /= 2;
        ++res;
        return num == 1 ? false : res == num;
    }

    public boolean checkPerfectNumber1(int num) {
        if (num <= 0)
            return false;
        int res = 0;
        for (int i = 1; i * i < num ; i++) {
            if (num % i == 0){
                res += i + num / i;
            }
        }
        return res - num == num;
    }
}
