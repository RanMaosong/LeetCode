package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/20
 * @email maosongran@gmail.com
 */
public class Leetcode_669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        if (root.val < L)
            return trimBST(root.right, L, R);
        else if (root.val > R)
            return  trimBST(root.left, L, R);
        else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }
}
