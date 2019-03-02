package com.rms.leetcode;

import java.util.Stack;

public class Leetcode_844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                s.push(c);
            } else {
                if (!s.empty())
                    s.pop();
            }
        }


        for (int i=T.length()-1; i >= 0 ; --i) {
            char c = T.charAt(i);
            if (c == '#') {
                s.push('#');
            } else {
                if (s.empty())
                    return  false;
                char top = s.peek();
                if (c == top || top == '#')
                    s.pop();
                else
                    return  false;
            }
        }

        while (!s.empty()) {
            if (s.pop() != '#')
                return false;
        }

        return  true;
    }
}
