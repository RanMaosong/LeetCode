package com.rms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Maosong Ran
 * @date 2019/02/22
 * @email maosongran@gmail.com
 */
public class Leetcode_771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int res = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c))
                ++res;
        }

        return res;
    }
}
