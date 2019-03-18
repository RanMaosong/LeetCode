package com.rms.leetcode;

import java.util.Arrays;

public class Leetcode_60 {
    int[] nums = new int[9];
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i <= n; ++i)
            sb.append(i);
        return operation1(sb.toString(), k, 1);
    }

    private String operation(String numStr, int k) {
        if (k == 1)
            return numStr;
        int index = numStr.length()-1;
        int tmp;
        if (nums[index] != 0)
            tmp = nums[index];
        else {
            tmp = jiecheng(index);
            nums[index] = tmp;
        }

        if (tmp < k) {
            char[] c = numStr.toCharArray();
            if (c[0] < c[1]) {
                char x = c[0];
                c[0] = c[1];
                c[1] = x;
            } else {
                for (int i=1; i < c.length; ++i) {
                    if (c[0] < c[i]) {
                        char x = c[0];
                        c[0] = c[i];
                        c[i] = x;
                        break;
                    }
                }
            }
            return operation(new String(c), k -tmp);
        } else {
            return numStr.charAt(0) + operation(numStr.substring(1), k);
        }
    }

    private String operation1(String numStr, int k, int next) {
        if (k == 1)
            return numStr;
        int index = numStr.length()-1;
        int tmp;
        if (nums[index] != 0)
            tmp = nums[index];
        else {
            tmp = jiecheng(index);
            nums[index] = tmp;
        }

        if (tmp < k) {
            char[] c = numStr.toCharArray();
            char x = c[0];
            c[0] = c[next];
            c[next] = x;
            return operation1(new String(c), k -tmp, ++next);
        } else {
            return numStr.charAt(0) + operation1(numStr.substring(1), k, 1);
        }
    }

    private int jiecheng(int n) {
        if (n <= 0)
            return 1;
        else return n*jiecheng(n-1);
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_60().getPermutation(4, 11));
    }
}
