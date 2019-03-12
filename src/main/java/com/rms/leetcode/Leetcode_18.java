package com.rms.leetcode;

import java.util.*;

public class Leetcode_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < n - 3; ++i) {
            List<List<Integer>> three = threeSum(nums, target - nums[i], i+1);
            for (List<Integer> tmp : three) {
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }

        return new ArrayList<>(res);
    }

    public List<List<Integer>> threeSum(int[] nums, int target, int i) {
        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        for (; i < n; ++i) {
            int l=i+1, r = n-1;
            while (l < r) {
                if (nums[l] + nums[r] + nums[i] > target)
                    --r;
                else if (nums[l] + nums[r] + nums[i] < target)
                    ++l;
                else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    res.add(tmp);
                    ++l;
                    --r;
                }
            }

        }


        return new ArrayList<>(res);
    }

    public static void main(String[] args) {

    }
}
