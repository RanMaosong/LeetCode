package com.rms.leetcode;

import java.util.HashMap;

public class Leetcode_788 {
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i=1; i <= N; ++i) {
            if (isGoodNum(i))
                ++res;
        }

        return res;
    }

    private boolean isGoodNum(int num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(9, 6);
        int newNum = 0, m = 1, num1 = num;
        while (num1 > 0) {
            int digit = num1 % 10;
            if (map.containsKey(digit)) {
                newNum = map.get(digit) * m + newNum;
                num1 /= 10;
                m *= 10;
            } else {
                break;
            }
        }

        if (num1 == 0 && num != newNum) {
            System.out.println("num = " + num + ", num1 = " + num1);
            return true;
        }

        else
            return false;
    }

    private boolean isGoodNum1(int num) {
        if (num == 0)
            return false;
        boolean res = false;
        while (num > 0) {
            int remain = num % 10;
            if (remain == 6 || remain == 9 || remain == 2 || remain ==5) {
                res = true;
            } else if (remain == 3 || remain == 4 || remain == 7){
                return  false;
            }
            num /= 10;
        }


        return res;
    }
}
