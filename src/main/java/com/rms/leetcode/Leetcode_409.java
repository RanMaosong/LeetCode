package com.rms.leetcode;

import java.util.HashMap;

/**
 * @author Maosong Ran
 * @date 2019/01/11
 * @email maosongran@gmail.com
 */
public class Leetcode_409 {
    // 动态规划
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }
        boolean flag = true;
        int result = 0;
        for(char c: map.keySet()) {
            if (map.get(c) % 2 == 0) {
                result += map.get(c);
            } else {
                if (flag) {
                    result += map.get(c);
                    flag = false;
                }

                else
                    result += map.get(c) - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_409().longestPalindrome("dccaccdd"));
    }
}
