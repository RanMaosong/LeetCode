package com.rms.leetcode;

import java.util.HashMap;

public class LeetCode_13 {
    /**
     * I: 1
     * V: 5
     * X: 10
     * L: 50
     * C: 100
     * D: 500
     * M: 1000
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        HashMap<Character, Integer> value = new HashMap<Character, Integer>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);

        int result = 0;
        int i;
        for (i=0; i<s.length()-1; ++i) {
            if (value.get(s.charAt(i)) >= value.get(s.charAt(i+1))) {
                result += value.get(s.charAt(i));
            } else {
                result += value.get(s.charAt(i+1)) - value.get(s.charAt(i));
                ++i;
            }
        }

        if (i == s.length()-1) {
            result += value.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_13 leetcode = new LeetCode_13();
        System.out.println(leetcode.romanToInt("III"));
        System.out.println(leetcode.romanToInt("IV"));
        System.out.println(leetcode.romanToInt("IX"));
        System.out.println(leetcode.romanToInt("LVIII"));
        System.out.println(leetcode.romanToInt("MCMXCIV"));
    }
}
