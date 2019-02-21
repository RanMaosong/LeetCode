package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_687 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        operation(root, root);
        return max;

    }

    private int operation(TreeNode root, TreeNode parent) {
        if (root == null) {
            return 0;
        }

        int left = operation(root.left, root), right = operation(root.right, root);
        left = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        right = (root.right != null && root.right.val == root.val) ? right + 1 : 0;
        max = Math.max(left + right, max);
        return Math.max(left, right);
    }
}
