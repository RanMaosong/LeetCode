package com.rms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_884 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" "), b = B.split(" ");
        Map<String, Integer> map1 = new HashMap<>();
        for (String s : a) {
            int count = map1.getOrDefault(s, 0);
            map1.put(s, ++count);
        }

        Map<String, Integer> map2 = new HashMap<>();
        for (String s : b) {
            int count = map2.getOrDefault(s, 0);
            map2.put(s, ++count);
        }
        List<String> res = new ArrayList<>();
        for (String k : map1.keySet()) {
            if (map1.getOrDefault(k, 0) == 1 && !map2.containsKey(k))
                res.add(k);
        }

        for (String k : map2.keySet()) {
            if (map2.getOrDefault(k, 0) == 1 && !map1.containsKey(k))
                res.add(k);
        }
        String[] s = new String[res.size()];
        return  res.toArray(s);
    }

    public String[] uncommonFromSentences1(String A, String B) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s: A.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String k : B.split(" ")) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        for (String k : map.keySet()) {
            if (map.getOrDefault(k, 0) == 1)
                res.add(k);
        }

        return res.toArray(new String[res.size()]);
    }
}
