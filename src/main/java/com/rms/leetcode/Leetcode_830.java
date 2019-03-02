package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        char[] c = S.toCharArray();
        int n = S.length();
        List<List<Integer>> res = new ArrayList<>();
        int i, j;
        for (i=1, j =0; i < n; ++i) {
            if (c[i] != c[i-1]) {
                if (i - j >= 3) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(j);
                    tmp.add(i-1);
                    res.add(tmp);
                }
                j = i;
            }
        }

        if (i - j >= 3) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(j);
            tmp.add(i-1);
            res.add(tmp);
        }

        return  res;
    }
}
