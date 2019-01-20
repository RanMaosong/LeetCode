package com.rms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_500 {
    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('a', 1);
        map.put('s', 1);
        map.put('d', 1);
        map.put('f', 1);
        map.put('g', 1);
        map.put('h', 1);
        map.put('j', 1);
        map.put('k', 1);
        map.put('l', 1);
        map.put('z', 2);
        map.put('x', 2);
        map.put('c', 2);
        map.put('v', 2);
        map.put('b', 2);
        map.put('n', 2);
        map.put('m', 2);
        List<String> res = new ArrayList<String>();
        for (String word : words) {
//            word = word.toLowerCase();
            int row = map.getOrDefault(Character.toLowerCase(word.charAt(0)), 0);
            boolean flag = true;
            for (char c : word.toCharArray()) {
                char lowerc = Character.toLowerCase(c);
                if (map.getOrDefault(lowerc, 0) != row) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                res.add(word);
        }
        String[] tmp = new String[res.size()];
        for (int i=0; i < res.size(); ++i) {
            tmp[i] = res.get(i);
        }

        return tmp;
    }
}
