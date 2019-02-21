package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/20
 * @email maosongran@gmail.com
 */
public class Leetcode_686 {
    public int repeatedStringMatch(String A, String B) {
        int n1 = A.length(), n2 = B.length();

        StringBuilder tmp = new StringBuilder();
        for (int i=0; i < n2 / n1 + 2; ++i) {
            tmp.append(A);
            if (tmp.indexOf(B) != -1)
                return i+1;
        }

        return -1;

    }
}
