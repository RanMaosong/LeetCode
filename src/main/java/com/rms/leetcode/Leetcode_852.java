package com.rms.leetcode;

public class Leetcode_852 {
    public int peakIndexInMountainArray(int[] A) {
        int i=1;

        while (A[i] < A[i+1])
            ++i;

        return i;
    }
}
