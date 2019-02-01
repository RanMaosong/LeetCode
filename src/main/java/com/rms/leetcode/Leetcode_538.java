package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/21
 * @email maosongran@gmail.com
 */
public class Leetcode_538 {
    public TreeNode convertBST(TreeNode root) {
        operation(root, 0);
        return root;
    }

    private void operation(TreeNode root, int sum) {
        if (root == null)
            return;
        operation(root.right, sum);
        if (root.right != null) {
//            root.val = root.val + root.right.val;
            TreeNode tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            root.val = root.val + tmp.val;
        }

        else
            root.val += sum;
        operation(root.left, root.val);
    }
}
