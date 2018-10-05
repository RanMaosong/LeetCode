package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/05
 * @email maosongran@gmail.com
 */
public class LeetCode_111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth(root.right) + 1;
        else if (root.right == null)
            return minDepth(root.left) + 1;
        else
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
