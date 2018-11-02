package com.rms.leetcode;

import java.util.HashMap;

/**
 * @author Maosong Ran
 * @date 2018/10/11
 * @email maosongran@gmail.com
 */
public class LeetCode_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> rep1 = new HashMap<Character, Character>();
        HashMap<Character, Character> rep2 = new HashMap<Character, Character>();
        int len = s.length();
        for(int i=0; i < len; ++i) {
            char s1 = s.charAt(i), t1 = t.charAt(i);
            if (rep1.containsKey(s1)) {
                if (rep1.get(s1) != t1)
                    return false;
            } else {
                if (rep2.containsKey(t1)) {
                    return false;
                }
                else {
                    rep1.put(s1, t1);
                    rep2.put(t1, s1);
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_205 leetCode = new LeetCode_205();
//        System.out.println(leetCode.isIsomorphic("egg", "add"));
//        System.out.println(leetCode.isIsomorphic("f00", "add"));
        System.out.println(leetCode.isIsomorphic("ab", "aa"));
    }
}
