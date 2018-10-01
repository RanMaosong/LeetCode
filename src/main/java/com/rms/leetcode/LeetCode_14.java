package com.rms.leetcode;

import java.util.ArrayList;

public class LeetCode_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        ArrayList<Character> list = new ArrayList<Character>();
        int minLength = strs[0].length();
        for (String s: strs) {
            int length = s.length();
            minLength = length<minLength ? length:minLength;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i < minLength; ++i) {
            for (int j=1; j<strs.length; ++j) {
                if (strs[j].charAt(i) != strs[j-1].charAt(i)) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(strs[0].charAt(i));
        }

        return stringBuilder.toString();
    }
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (String s: strs) {
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        LeetCode_14 leetcode = new LeetCode_14();
        System.out.println(leetcode.longestCommonPrefix2(new String[]{"flower","flow","flight"}));
        System.out.println(leetcode.longestCommonPrefix2(new String[]{"dog","racecar","car"}));
    }
}
