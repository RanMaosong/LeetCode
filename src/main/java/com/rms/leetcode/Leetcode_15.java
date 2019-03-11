package com.rms.leetcode;

import java.util.*;

public class Leetcode_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        for (int i=0; i < n; ++i) {
            if (nums[i] > 0)
                break;
            else {
                int l=i+1, r = n-1;
                while (l < r) {
                    if (nums[l] + nums[r] > -nums[i])
                        --r;
                    else if (nums[l] + nums[r] < -nums[i])
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
        }


        return new ArrayList<>(res);

    }

    public static void main(String[] args) {
        new Leetcode_15().threeSum(new int[]{0, 0, 0})
    }
}
