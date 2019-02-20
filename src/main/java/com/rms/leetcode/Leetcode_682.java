package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2019/02/20
 * @email maosongran@gmail.com
 */
public class Leetcode_682 {
    public int calPoints(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        int i=-1;
        int sum = 0;
        for (String s : ops) {
            if (s.equals("C")) {
                sum -= scores.get(i);
                scores.remove(i);
                --i;
            } else if (s.equals("D")) {
                sum += scores.get(i) * 2;
                scores.add(scores.get(i) * 2);
                ++i;

            } else if (s.equals("+")) {
                sum += scores.get(i) + scores.get(i-1);
                scores.add(scores.get(i) + scores.get(i-1));
                ++i;
            } else {
                scores.add(Integer.valueOf(s));
                sum +=Integer.valueOf(s);
                ++i;
            }
        }

        return sum;
    }
}
