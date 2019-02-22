package com.rms.leetcode;

import java.util.Stack;

/**
 * @author Maosong Ran
 * @date 2019/02/22
 * @email maosongran@gmail.com
 */
public class Leetcode_783 {
    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode pre = null;
        int res = Integer.MAX_VALUE;
        TreeNode node = root.left;
        while (node != null || !s.isEmpty()) {

            while (node != null) {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            if (pre == null) {
                pre = node;
            } else {
                res = Math.min(res, (node.val - pre.val));
                pre = node;
            }

            node = node.right;


        }

        return res;
    }
}
