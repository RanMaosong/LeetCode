package com.rms.leetcode;

import java.util.*;

public class Leetcode_39 {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        operation(candidates, target, cur, 0);
        return new ArrayList<List<Integer>>(res);
    }

    private void operation(int[] candidates, int target, List<Integer> cur, int pos) {
        if (target < 0)
            return;
        else if (target == 0) {
            List<Integer> node = new ArrayList<>(cur);
            res.add(node);
        } else {
            for (int i=pos; i < candidates.length; ++i) {
                if (candidates[i] <= target ) {
                    cur.add(candidates[i]);
                    operation(candidates, target - candidates[i], cur, i+1);
                    cur.remove(cur.size()-1);
                } else {
                    break;
                }

            }
        }
    }

    List<List<Integer>> res1 = new ArrayList<>();
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        operation1(candidates, target, cur, 0);
        return res1;
    }
    private void operation1(int[] candidates, int target, List<Integer> cur, int pos) {
        if (target < 0)
            return;
        else if (target == 0) {
            List<Integer> node = new ArrayList<>(cur);
            res1.add(node);
        } else {
            for (int i=pos; i < candidates.length && candidates[i] <= target;) {
                List<Integer> list = new ArrayList<>(cur);
                list.add(candidates[i]);
                operation(candidates, target-candidates[i], list, i+1);
                ++i;
                while (i < candidates.length && candidates[i] == candidates[i-1])
                    ++i;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_39().combinationSum(new int[]{2, 3, 6, 7}, 7));

    }
}
