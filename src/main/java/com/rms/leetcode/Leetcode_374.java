package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/10
 * @email maosongran@gmail.com
 */
class GuessGame {
    int guess(int num) {
        if (num > 6)
            return 1;
        else if (num < 6)
            return -1;
        else
            return 0;
    }
}
public class Leetcode_374 extends GuessGame {
    public int guessNumber(int n) {
        int i=1, j=n;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (guess(mid) == 1) {
                i = mid + 1;
            } else if (guess(mid) == -1) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_374().guessNumber(10));
    }
}
