package com.rms.leetcode;

import java.util.*;

public class Leetcode_46 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> origin = new HashSet<>();
        List<Integer> set = new ArrayList<>();
        for (int num : nums)
            origin.add(num);
        operation(origin, set);
        return res;
    }
    private void operation(Set<Integer> origin, List<Integer> set) {
//        System.out.println(origin +" " + set);
        if (origin.size() == 0) {
            res.add(new ArrayList<>(set));
        } else {
            for (int num : origin) {
                Set<Integer> newOrigin = new HashSet<>(origin);
                List<Integer> newSet = new ArrayList<>(set);
                newOrigin.remove(num);
                newSet.add(num);
                operation(newOrigin, newSet);
            }
        }

    }
    public List<List<Integer>> permute1(int[] nums) {
        if (nums.length == 0)
            return  new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> node = new ArrayList<>();
        node.add(nums[0]);
        res.add(node);
        for (int i=1; i < nums.length; ++i) {
            List<List<Integer>> next = new ArrayList<>();
            for (List<Integer> tmp : res) {
                for (int j=0; j <= tmp.size(); ++j) {
                    List<Integer> newNode = new ArrayList<>(tmp);
                    newNode.add(j, nums[i]);
                    next.add(newNode);
                }
            }
            res = next;
        }

        return res;
    }

    public List<List<Integer>> permute2(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<List<Integer>>();
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> node = new ArrayList<>();
        for (int num : nums)
            node.add(num);
        res.add(node);
        for (int i=0; i < nums.length; ++i) {
            List<Integer> newNode = new ArrayList<>(node);
            newNode.remove(i);
            for (int j=0; j <= newNode.size(); ++j) {
                    List<Integer> cur = new ArrayList<>(newNode);
                    cur.add(j, node.get(i));
                    res.add(cur);
            }
        }

        return new ArrayList<>(res);

    }

    public static void main(String[] args) {
        System.out.print(new Leetcode_46().permute2(new int[]{1, 2, 3}));
    }
}
