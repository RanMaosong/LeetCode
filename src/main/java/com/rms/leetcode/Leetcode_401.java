package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2019/01/11
 * @email maosongran@gmail.com
 */
public class Leetcode_401 {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int h=0; h < 12; ++h) {
            for (int m=0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    String tmp = "" +h + ":";
                    if (m < 10) {
                        tmp += "0" + m;
                    } else {
                        tmp += m;
                    }

                    result.add(tmp);
                }
            }
        }

        return result;
    }
}
