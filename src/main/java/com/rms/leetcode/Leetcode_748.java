package com.rms.leetcode;

import java.util.*;

/**
 * @author Maosong Ran
 * @date 2019/02/22
 * @email maosongran@gmail.com
 */
public class Leetcode_748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> set1 = new HashMap<>();
        for (char c : licensePlate.toCharArray()) {
            if ((c >= 60 && c <= 90) || (c >= 97 && c <= 122)) {
                char key = Character.toLowerCase(c);
                int count = set1.getOrDefault(key, 0);
                set1.put(key, ++count);
            }

        }
        String res = "";
//        Arrays.sort(words);
        for (String word : words) {
            Map<Character, Integer> set2 = new HashMap<>();
            for (char c : word.toCharArray()) {
                char key = Character.toLowerCase(c);
                int count = set2.getOrDefault(key, 0);
                set2.put(key, ++count);
            }
            System.out.println(set1.toString() + " " + set2.toString());
            boolean flag = true;
            for (char c : set1.keySet()) {
                if (set1.get(c) > set2.getOrDefault(c, 0)) {
                    flag = false;
                    break;
                }

            }
            if (flag)
                System.out.println(word);
            if (flag && (word.length() < res.length() || res.length() == 0)) {
                res = word;
            }
        }
        return res;
    }
}
