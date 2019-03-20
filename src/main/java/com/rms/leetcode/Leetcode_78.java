package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int num : nums) {
            if (!res.isEmpty()) {
                int n = res.size();
                for (int i=0; i < n; ++i) {
                    List<Integer> node = new ArrayList<>(res.get(i));
                    node.add(num);
                    res.add(node);
                }
            }
            List<Integer> node = new ArrayList<>();
            node.add(num);
            res.add(node);
        }
        List<Integer> node = new ArrayList<>();
        res.add(node);
        return res;


    }

    public static void main(String[] args) {

    }
}
