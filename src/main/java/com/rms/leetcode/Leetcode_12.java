package com.rms.leetcode;

public class Leetcode_12 {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] s = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i=0; i < 13; ++i) {
            while (num >= values[i]) {
                res.append(s[i]);
                num -= values[i];
            }
        }

        return res.toString();
    }
}
