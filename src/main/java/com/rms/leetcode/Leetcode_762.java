package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/22
 * @email maosongran@gmail.com
 */
public class Leetcode_762 {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (; L<=R; ++L) {
            int sum = 0, tmp = L;
            while (tmp !=0) {
                if (tmp %2 == 1)
                    ++sum;
                tmp >>= 2;
            }

            if (isPrime(sum))
                ++res;
        }

        return res;
    }
    private boolean isPrime(int num) {
        if (num < 2)
            return false;
        if (num == 2 || num == 3)
            return true;
        int n = (int) Math.sqrt(num);
        for (int i=2; i <= n; ++i) {
            if (num % i == 0)
                return  false;
        }

        return true;
    }
}
