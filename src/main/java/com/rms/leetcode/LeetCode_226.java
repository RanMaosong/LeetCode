package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/12/22
 * @email maosongran@gmail.com
 */
public class LeetCode_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        invertTree(left);
        invertTree(root.left);

        return root;
    }
}
