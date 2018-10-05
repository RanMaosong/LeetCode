package com.rms.leetcode;

public class LeetCode_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricTree(root.left, root.right);

    }

    private boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if (p == null)
            return q == null;
        if (q == null)
            return p == null;

        if (p.val == q.val) {
            return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
        } else {
            return false;
        }
    }

}
