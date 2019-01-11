package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/11
 * @email maosongran@gmail.com
 */
public class Leetcode_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        return operation(root.left, true) + operation(root.right, false);
    }

    private int operation(TreeNode root, boolean flag) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null && flag)
            return root.val;

        return operation(root.left, true) + operation(root.right, false);
    }
}
