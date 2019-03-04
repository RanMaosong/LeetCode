package com.rms.leetcode;

public class Leetcode_868 {
    public int binaryGap(int N) {
        int res = -1, start = -1, i = 0;
        while (N !=0 ) {
            int remain = N % 2;
            if (remain == 1 && start == -1) {
                start = i;
            } else if (remain == 1) {
                res = res > (i - start) ? res : i - start;
                start = i;
            }

            N /= 2;
            ++i;
        }

        return res == -1 ? 0 : res;
    }
}
