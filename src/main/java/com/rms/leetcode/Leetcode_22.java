package com.rms.leetcode;

import java.util.*;

public class Leetcode_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateAll(new char[n*2], 0, res);
        return res;
    }

    private void generateAll(char[] c, int pos, List<String> list) {
        if (pos == c.length) {
            if (isValid(c))
                list.add(new String(c));
        } else {
            c[pos] = '(';
            generateAll(c, pos+1, list);
            c[pos] = ')';
            generateAll(c, pos+1, list);
        }
    }

    private boolean isValid(char[] cs) {
        int balance = 0;
        for (char c : cs) {
            if (c == '(')
                ++balance;
            else
                --balance;
            if (balance < 0)
                return false;
        }

        return balance == 0;
    }

    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        generateAll1(new char[n*2], 0, 0,  res);
        return res;
    }

    private void generateAll1(char[] c, int pos, int balance, List<String> list) {
//        System.out.println(Arrays.toString(c) + balance);
        if (balance < 0 || (balance > c.length - pos))
            return;
        else if (pos == c.length) {
            if (balance == 0)
                list.add(new String(c));
        } else {
            c[pos] = '(';
            generateAll1(c, pos+1, balance+1, list);
            c[pos] = ')';
            generateAll1(c, pos+1, balance-1, list);
        }
    }


    public static void main(String[] args) {
            System.out.println(new Leetcode_22().generateParenthesis1(3));
    }
}
