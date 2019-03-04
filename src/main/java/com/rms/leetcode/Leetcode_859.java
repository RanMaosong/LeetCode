package com.rms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_859 {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        int n = A.length();
        int i=0;
        Set<Character> set = new HashSet<>();
        while (i < n && A.charAt(i) == B.charAt(i)) {
            set.add(A.charAt(i));
            ++i;
        }

        if (i == n) {
            return set.size() < n;
        }

        int j = n -1;
        while (j >= 0 && A.charAt(j) == B.charAt(j))
            --j;

        if (j == i)
            return false;
        if (A.charAt(i) != B.charAt(j))
            return false;
        if (A.charAt(j) != B.charAt(i))
            return false;

        for (i = i + 1; i < j; ++i) {
            if (A.charAt(i) != B.charAt(i))
                return false;
        }

        return true;
    }
}
