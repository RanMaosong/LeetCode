package com.rms.leetcode;

public class Leetcode_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        boolean tmp = equal(s, t);
        boolean left = isSubtree(s.left, t);
        boolean right = isSubtree(s.right, t);
        return tmp || left || right;

    }
    private boolean equal(TreeNode s, TreeNode t) {
        if (t == null)
            return s == null;
        if (s == null)
            return t == null;
        if (s.val == t.val) {
            boolean left = equal(s.left, t.left);
            boolean right = equal(s.right, t.right);
            return left && right;
        } else {
            return false;
        }
    }
}
