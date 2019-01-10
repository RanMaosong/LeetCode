package com.rms.leetcode;

import java.util.HashMap;

/**
 * @author Maosong Ran
 * @date 2019/01/10
 * @email maosongran@gmail.com
 */
public class Leetcode_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c: magazine.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }

        for (char c : ransomNote.toCharArray()) {
            int count = map.getOrDefault(c, 0) - 1;
            if (count < 0)
                return false;
            map.put(c, count);
        }

        return true;
    }
}
