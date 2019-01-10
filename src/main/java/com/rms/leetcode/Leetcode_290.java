package com.rms.leetcode;

import java.util.HashMap;

/**
 * @author Maosong Ran
 * @date 2019/01/10
 * @email maosongran@gmail.com
 */
public class Leetcode_290 {
    public boolean wordPattern(String pattern, String str) {
        char[] c = pattern.toCharArray();
        String[] words = str.split(" ");
        if (c.length != words.length)
            return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        for (int i=0; i < words.length; ++i) {
            if (map.containsKey(c[i])) {
                if (!map.get(c[i]).equals(words[i]))
                    return false;
            } else {
                if (map.containsValue(words[i]))
                    return false;
                else
                    map.put(c[i], words[i]);
            }
        }

        return true;
    }
}
