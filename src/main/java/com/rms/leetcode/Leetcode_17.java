package com.rms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_17 {
    public List<String> letterCombinations(String digits) {
        char[] cs = digits.toCharArray();
        List<List<Character>> list = new ArrayList<>();
        int start = 97;
        List<String> res = new ArrayList<>();

        if (digits.length() == 0)
            return res;
        res.add("");
        for (int i=2;i <= 9; ++i) {
            List<Character> node = new ArrayList<>();
            for (int j=0; j < 3; ++j) {
                node.add((char)start++);
            }

            if (i == 7 || i == 9)
                node.add((char)start++);
            list.add(node);
        }

        for (char c : cs) {
            List<String> res1 = new ArrayList<>();
            List<Character> node = list.get((int)c-50);
            for (char a : node) {
                for (String b : res) {
                    res1.add(b + a);
                }
            }

            res.clear();
            res = res1;
        }


        return res;
    }

    public static void main(String[] args) {
        System.out.println((int)'1');
    }
}
