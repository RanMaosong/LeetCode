package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/14
 * @email maosongran@gmail.com
 */
public class Leetcode_434 {
    public int countSegments(String s) {
        if (s.length() == 0)
            return 0;
        int result = 0;
        boolean flag = false;
        for (char c : (s + " ").toCharArray()) {
            if (c == ' ' && flag) {
                ++result;
                flag = false;
            } else {
                flag = c != ' ' ? true : false;
            }

        }
        return result;
    }
}
