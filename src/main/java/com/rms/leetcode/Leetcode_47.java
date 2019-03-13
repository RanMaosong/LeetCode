package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {


        if (nums.length == 0)
            return  new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> node = new ArrayList<>();
        node.add(nums[0]);
        res.add(node);
        for (int i=1; i < nums.length; ++i) {
            List<List<Integer>> next = new ArrayList<>();
            for (List<Integer> tmp : res) {
                for (int j=0; j <= tmp.size(); ) {
                    List<Integer> newNode = new ArrayList<>(tmp);
                    newNode.add(j, nums[i]);
                    next.add(newNode);
                    ++j;
                    if (j < tmp.size() - 2 && nums[i] == tmp.get(j-1)) {
                        ++j;
                        while ( j < tmp.size() && tmp.get(j) == tmp.get(j-1))
                            ++j;
                    }

                }
            }
            res = next;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.print(new Leetcode_47().permuteUnique(new int[]{1, 1, 2}));
    }
}
