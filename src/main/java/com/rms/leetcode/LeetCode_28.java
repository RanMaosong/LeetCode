package com.rms.leetcode;

public class LeetCode_28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        int needleLen = needle.length();
        for(int i=0; i < haystack.length()-needleLen; ++i) {
            if (haystack.substring(i, i + needleLen).equals(needle))
                return i;
        }

        return -1;
    }
    public int strStr2(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();

        if (n == 0)
            return 0;
        if (m < n)
            return -1;
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();

        for (int i = 0; i <= m-n; ++i) {
            int j;
            for(j=0; j < n; ++j) {
                if (chars1[i+j] != chars2[j])
                    break;
            }
            if (j == n)
                return i;
        }

        return -1;
    }

    public static  void main(String[] args) {
        LeetCode_28 leetCode = new LeetCode_28();
        System.out.println(leetCode.strStr2("hello", "ll"));
        System.out.println(leetCode.strStr2("aaaaa", "bba"));
    }
}
