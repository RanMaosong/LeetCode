package com.rms.leetcode;

public class Leetcode_925 {
    public boolean isLongPressedName(String name, String typed) {
        char[] a = name.toCharArray(), b = typed.toCharArray();
        int n1 = a.length, n2 = b.length, diff = n2 - n1;
        if (diff < 0)
            return false;
        int i=0, j = 0;
        while (i < n1) {
            if (a[i] == b[j]) {
                ++i;
                ++j;
            } else {
                if (j == 0 || b[j] == b[j-1]) {
                    ++j;
                    --diff;
                }

                else
                    return false;
            }

            if (diff < 0)
                return false;
        }

        while (j < n2) {
            if(b[j] != a[i-1])
                return false;
            ++j;
        }

        return true;
    }
}
