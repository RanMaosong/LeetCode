package com.rms.leetcode;

public class LeetCode_10 {

    public boolean isMatch(String s, String p) {
        System.out.println(s + "," + p);
        if (p.isEmpty())
            return s.isEmpty();
        else if (p.length()>1 && p.charAt(1) == '*') {
            return  isMatch(s, p.substring(2)) || (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p));
        } else {
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }

    }

    public static void main(String[] args) {
        LeetCode_10 temp = new LeetCode_10();
        System.out.println(temp.isMatch("aa", "a"));
    }
}
