package com.rms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_575 {
    public int distributeCandies(int[] candies) {
        int n = candies.length / 2;
        Set<Integer> set = new HashSet<>();
        for(int num : candies) {
            set.add(num);
            if (set.size() == n)
                return n;
        }

        return set.size();
    }
}
