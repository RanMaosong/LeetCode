package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        res.add(0);
        res.add(1);
        for (int i=2; i<=n; ++i) {
            int size = res.size();
            int prefix = 1 << (i-1);
            for (int j=size-1; j >= 0; --j) {
                res.add(res.get(j) + prefix);
            }
        }

        return res;
    }

    public List<Integer> grayCode1(int n) {
        int size = 1 << n;
        List<Integer> res = new ArrayList<>();
        for (int i=0; i < size; ++i)
            res.add(i^(i>>1));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_89().grayCode1(2));
    }
}
