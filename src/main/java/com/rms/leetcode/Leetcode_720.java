package com.rms.leetcode;

import java.util.*;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_720 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String res = "";
        Set<String> set = new HashSet<>();
        for (String s : words) {
            if (s.length() == 1 || set.contains(s.substring(0, s.length()-1))) {
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }

        return res;
    }
}
