package com.rms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maosong Ran
 * @date 2019/01/14
 * @email maosongran@gmail.com
 */
public class Leetcode_447 {
    public int numberOfBoomerangs(int[][] points) {
        int len1 = points.length;
        int res = 0;
        for (int i=0; i < len1; ++i) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j=0; j<len1; ++j) {
                int len = (int) (Math.pow(points[i][0]-points[j][0], 2) + Math.pow(points[i][1]-points[j][1], 2));
                int count = map.getOrDefault(len, 0);
                map.put(len, count+1);
                if (count > 0) {
                    res += 2 * count;
                }
            }
        }

        return res;

    }
}
