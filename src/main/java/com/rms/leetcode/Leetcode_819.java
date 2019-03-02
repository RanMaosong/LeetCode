package com.rms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>();
        for (String s : banned)
            ban.add(s);
        Map<String, Integer> map = new HashMap<>();
        int i=0, j=0, n = paragraph.length();
        int max = 0;
        String res = "";
        paragraph = paragraph.toLowerCase();
        while (true) {
            while (i < n && (paragraph.charAt(i) < 97 || paragraph.charAt(i) > 122))
                ++i;
            j = i+1;
            while (j < n && ((paragraph.charAt(j) >= 97 && paragraph.charAt(j) <= 122)))
                ++j;
            if ( i < n) {
                String k = paragraph.substring(i, j);
                if (k != null && !ban.contains(k)) {
                    int count = map.getOrDefault(k, 0);
                    if (count + 1 > max) {
                        max = count;
                        res = k;
                    }

                    map.put(k, ++count);
                }
                i = j + 1;
            }else {
                break;
            }

        }

        return res;
    }
}
