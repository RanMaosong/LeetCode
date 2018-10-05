package com.rms.leetcode;

public class LeetCode_104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.left) + 1, right = maxDepth(root.right) + 1;

        return left > right ? left : right;
    }
}
