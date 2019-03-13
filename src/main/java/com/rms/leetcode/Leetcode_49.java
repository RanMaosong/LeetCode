package com.rms.leetcode;

import java.util.*;

public class Leetcode_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String k = String.valueOf(c);
            if (!map.containsKey(k))
                map.put(k, new ArrayList<>());
            map.get(k).add(s);
        }

        return new ArrayList<List<String>>(map.values());

    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
