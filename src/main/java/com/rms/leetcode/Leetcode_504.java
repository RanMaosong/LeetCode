package com.rms.leetcode;

import java.util.Stack;

/**
 * @author Maosong Ran
 * @date 2019/01/18
 * @email maosongran@gmail.com
 */
public class Leetcode_504 {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            sb.append("-");
            num = Math.abs(num);
        }

        while (num != 0) {
            s.push(num % 7);
            num /= 7;
        }

        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        return sb.toString();

    }
}
