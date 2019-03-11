package com.rms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> res = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(codes[c-97]);
            }
            res.add(sb.toString());
        }

        return res.size();
    }
}
