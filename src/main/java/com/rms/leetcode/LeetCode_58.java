package com.rms.leetcode;

public class LeetCode_58 {
    /**
     * 利用Java特性
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0)
            return 0;
        String[] strs = s.split(" ");
        return strs[strs.length-1].length();
    }

    /**
     * 逆序遍历
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s) {
        int count = 0;
        int len = s.length();

        for(int i=len-1; i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                ++count;
            } else if (s.charAt(i) == ' ' && count != 0) {
                return count;
            }
        }

        return count;
    }
}
