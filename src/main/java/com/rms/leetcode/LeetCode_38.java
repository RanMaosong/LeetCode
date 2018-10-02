package com.rms.leetcode;

public class LeetCode_38 {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        else if (n == 2)
            return "11";
        String result = "11";
        for(int i=0; i < n - 2; ++i) {
            result = count(result);
        }

        return result;
    }

    private String count(String nums) {
        char[] chars = nums.toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = nums.length();
        int i, j;
        for (i=0; i<len; i=j) {
            for (j=i+1; j < len; ++j) {
                if (chars[j] != chars[i])
                    break;
            }

            sb.append(j-i);
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode_38 leetCode = new LeetCode_38();
        System.out.println(leetCode.countAndSay(3));
        System.out.println(leetCode.countAndSay(4));
        System.out.println(leetCode.countAndSay(6));
    }
}
