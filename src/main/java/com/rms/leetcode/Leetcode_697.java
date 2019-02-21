package com.rms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> index = new HashMap<>();
        int max = 0, res = Integer.MAX_VALUE;
        for (int i=0; i < nums.length; ++i) {
            int num = nums[i];
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
            if (!index.containsKey(num)) {
                index.put(num, i);
            }
            int tmp = i - index.get(num) + 1;
            if (max < count || (max == count && tmp < res)) {
                res = tmp;
                max = count;
            }



        }

        return res;
    }
}
