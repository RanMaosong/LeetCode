package com.rms.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_501 {
    public int[] findMode(TreeNode root) {
        List<Integer> sortedArr = new ArrayList<>();
        operation(root, sortedArr);
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : sortedArr) {
            int count = map.getOrDefault(num, 0 ) + 1;
            map.put(num, count);
            if (count == max)
                max = count ;
        }
        sortedArr.clear();
        for (int key : map.keySet()) {
            if (map.get(key) == max)
                sortedArr.add(key);
        }

        int[] res = new int[sortedArr.size()];
        for (int i =0; i < res.length; ++i) {
            res[i] = sortedArr.get(i);
        }

        return res;
    }

    private void operation(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        operation(root.left, list);
        list.add(root.val);
        operation(root.right, list);
    }

    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode1(TreeNode root) {
        List<Integer> sortedArr = new ArrayList<>();
        operation1(root);
        for (int key : map.keySet()) {
            if (map.get(key) == max)
                sortedArr.add(key);
        }

        int[] res = new int[sortedArr.size()];
        for (int i =0; i < res.length; ++i) {
            res[i] = sortedArr.get(i);
        }

        return res;
    }

    private void operation1(TreeNode root) {
        if (root == null)
            return;
        operation1(root.left);
        int count = map.getOrDefault(root.val, 0) + 1;
        map.put(root.val, count);
        if (count > max)
            max = count;
        operation1(root.right);
    }

}
