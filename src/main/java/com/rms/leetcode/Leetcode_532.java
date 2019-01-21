package com.rms.leetcode;

import java.util.*;

/**
 * @author Maosong Ran
 * @date 2019/01/21
 * @email maosongran@gmail.com
 */
public class Leetcode_532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;
        int res = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < n; ++i) {
            map.put(nums[i], i);
        }
        for (int i=0; i < n; ++i) {
            if (map.containsKey(nums[i]+k) && map.get(nums[i] + k) != i) {
                ++res;
                map.remove(nums[i] + k);
            }
        }

        return res;
    }
    public int findPairs1(int[] nums, int k) {
        if (k < 0 || nums.length < 2)
            return 0;
        int res =0, left=0, right=1, n = nums.length;
        Arrays.sort(nums);
        while (right < n) {
            int first = nums[left], sec = nums[right];
            if (sec - first < k) {
                ++right;
            } else if (sec - first > k) {
                ++left;
            } else {
                ++res;
                while (right < n && nums[right] == sec)
                    ++right;
                while (left < n && nums[left] == first)
                    ++left;
            }
            if (right == left)
                ++right;
        }
        return res;
    }
    public static void main(String[] args) {
        new Leetcode_532().findPairs(new int[]{3, 1, 4, 1, 5}, 2);
    }
}
