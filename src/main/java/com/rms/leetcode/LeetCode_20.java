package com.rms.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class LeetCode_20 {
    public boolean isValid(String s) {
        HashMap<Character, Character> match = new HashMap<Character, Character>();
        match.put('(', ')');
        match.put('[', ']');
        match.put('{', '}');

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c: chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if(!stack.isEmpty()) {
                char pop = stack.pop();
                if (match.get(pop) != c)
                    return false;

            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        LeetCode_20 leetcode = new LeetCode_20();
        System.out.println((leetcode.isValid("()")));
        System.out.println((leetcode.isValid("()[]{}")));
        System.out.println((leetcode.isValid("(]")));
        System.out.println((leetcode.isValid("([)]")));
        System.out.println((leetcode.isValid("{[]}")));
    }
}
