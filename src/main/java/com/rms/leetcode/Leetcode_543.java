package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/21
 * @email maosongran@gmail.com
 */
public class Leetcode_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int dl = diameterOfBinaryTree(root.left), dr = diameterOfBinaryTree(root.right);
        int hl = getHeight(root.left), hr = getHeight(root.right);
        int tmp1 = dl > dr ? dl : dr;
        int tmp2 = hl + hr;
        return tmp1 > tmp2 ? tmp1 : tmp2;
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int l = getHeight(root.left), r = getHeight(root.right);
        return (l > r ? l : r) + 1;
    }
}
