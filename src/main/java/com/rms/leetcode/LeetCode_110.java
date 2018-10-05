package com.rms.leetcode;

import java.util.HashMap;

/**
 * @author Maosong Ran
 * @date 2018/10/05
 * @email maosongran@gmail.com
 */
public class LeetCode_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }

    }
    private int heightOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = heightOfTree(root.left) + 1;
        int right = heightOfTree(root.right) + 1;
        return Math.max(left, right);
    }
}
