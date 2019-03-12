package com.rms.leetcode;

import java.util.*;

public class Leetcode_39 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        operation(candidates, target, cur, 0);
        return res;
    }

    private void operation(int[] candidates, int target, List<Integer> cur, int pos) {
        if (target < 0)
            return;
        else if (target == 0) {
            List<Integer> node = new ArrayList<>(cur);
            res.add(node);
        } else {
            for (int i=pos; i < candidates.length; ++i) {
                if (candidates[i] <= target) {
                    cur.add(candidates[i]);
                    operation(candidates, target - candidates[i], cur, i);
                    cur.remove(cur.size()-1);
                } else {
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_39().combinationSum(new int[]{2, 3, 6, 7}, 7));

    }
}
