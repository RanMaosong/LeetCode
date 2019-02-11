package com.rms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0, n = nums.length;
        for (int i=0; i < n; ++i) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++count);
            if (map.containsKey(nums[i]-1)) {
                int tmp = map.get(nums[i] - 1) + map.get(nums[i]);
                res = res > tmp ? res : tmp;
            }

            if (map.containsKey(nums[i]+1)) {
                int tmp = map.get(nums[i] + 1) + map.get(nums[i]);
                res = res > tmp ? res : tmp;
            }
        }

        return res;
    }
}
