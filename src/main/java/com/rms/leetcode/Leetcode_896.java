package com.rms.leetcode;

public class Leetcode_896 {
    public boolean isMonotonic(int[] A) {
        if (A.length < 1)
            return  true;
        int flag = 0;
        for (int i=1; i < A.length; ++i) {
            if (flag == -1 && A[i] > A[i-1]) {
                return  false;
            } else if (flag == 0 && A[i] != A[i-1]) {
                flag = A[i] > A[i-1] ? 1 : -1;
            } else if (flag == 1 && A[i] < A[i-1]){
                return false;
            }
        }

        return  true;
    }
}
