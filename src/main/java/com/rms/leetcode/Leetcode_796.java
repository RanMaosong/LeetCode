package com.rms.leetcode;

public class Leetcode_796 {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length())
            return false;
        String db = B + B;
        return db.indexOf(A) != -1;
    }
}
