package com.rms.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Maosong Ran
 * @date 2019/01/18
 * @email maosongran@gmail.com
 */
public class Leetcode_506 {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i=0; i < n; ++i) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);

        String[] res = new String[n];
        for (int i=n-1; i >= 0; --i) {
            int j = map.get(nums[i]);
            if (i == n-1) {
                res[j] = "Gold Medal";
            } else if (i == n-2) {
                res[j] = "Silver Medal";
            } else if (i == n-3) {

                res[j] = "Bronze Medal";
            } else {

                res[j] = "" + (n-i);
            }
        }

        return res;

    }
}
