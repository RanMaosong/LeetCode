package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        dfs(root1, left);
        dfs(root2, right);
        System.out.println(left);
        System.out.println(right);
        return  left.equals(right);
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
