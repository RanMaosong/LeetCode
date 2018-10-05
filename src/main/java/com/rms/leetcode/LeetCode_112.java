package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/05
 * @email maosongran@gmail.com
 */
public class LeetCode_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null && sum == 0)
            return false;
        else if (root == null && sum != 0)
            return false;
        else {
            int remains = sum - root.val;
            if (isLeaf(root))
                return remains == 0;
            return hasPathSum(root.left, remains) || hasPathSum(root.right, remains);

        }
    }

    private boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }
}
