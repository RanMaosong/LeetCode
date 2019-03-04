package com.rms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                ++five;
            } else if (bill == 10) {
                ++ten;
                if (five == 0)
                    return false;
                --five;
            } else {
                if (ten != 0) {
                    if (five == 0)
                        return  false;
                    --five;
                    --ten;
                } else {
                    if (five < 3)
                        return false;
                    five -= 3;
                }
            }
        }

        return true;


    }
}
