package com.rms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_824 {
    public String toGoatLatin(String S) {
        String[] ss = S.split(" ");
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < ss.length; ++i) {
            if (set.contains(ss[i].charAt(0))) {
                sb.append(ss[i]);
                sb.append("ma");
            } else {
                sb.append(ss[i].substring(1));
                sb.append(ss[i].charAt(0));
                sb.append("ma");
            }

            for (int j=0; j <= i; ++j) {
                sb.append("a");
            }
            sb.append(" ");
        }

        int n = sb.length();
        return sb.toString().substring(0, n-1);
    }
}
