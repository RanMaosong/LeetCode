package com.rms.leetcode;

import java.util.HashMap;

/**
 * @author Maosong Ran
 * @date 2019/01/11
 * @email maosongran@gmail.com
 */
public class Leetcode_387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chrs = s.toCharArray();
        for (char c: chrs) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }
        int len = chrs.length;
        for (int i=0; i < len; ++i) {
            int count = map.get(chrs[i]);
            if (count == 1)
                return  i;
        }

        return -1;
    }
}
