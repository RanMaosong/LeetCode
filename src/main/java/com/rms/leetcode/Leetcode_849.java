package com.rms.leetcode;

public class Leetcode_849 {
    public int maxDistToClosest(int[] seats) {
        int max = -1;
        int i=-1, n = seats.length, j;
        for (j=0; j < n; ++j) {
            if (seats[j] == 1) {
                if (i == -1) {
                    i = j;
                    max = j;
                } else {
                    max = max > (j-i)/2 ? max : (j-i) / 2;
                    i = j;
                }
            }
        }

        if (j-i != 1) {
            max = max > j-i - 1 ? max : j - i - 1;
        }

        return  max;
    }
}
