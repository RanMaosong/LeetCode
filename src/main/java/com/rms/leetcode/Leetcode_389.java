package com.rms.leetcode;

import java.util.HashMap;

/**
 * @author Maosong Ran
 * @date 2019/01/11
 * @email maosongran@gmail.com
 */
public class Leetcode_389 {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c:s.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }
        for (char c:t.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            if (count == 0)
                return c;
            map.put(c, count-1);
        }

        return ' ';
    }
}
