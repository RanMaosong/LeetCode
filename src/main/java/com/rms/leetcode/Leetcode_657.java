package com.rms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maosong Ran
 * @date 2019/02/19
 * @email maosongran@gmail.com
 */
public class Leetcode_657 {
    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('L', 1);
        map.put('R', -1);
        map.put('U', 1);
        map.put('D', -1);
        int[] move = new int[2];
        char[] tmp = moves.toCharArray();
        for (char c : tmp) {
            if (c == 'L' || c == 'R')
                move[0] += map.get(c);
            else
                move[1] += map.get(c);
        }

        for (int num : move) {
            if (num != 0)
                return false;
        }

        return true;
    }


}
