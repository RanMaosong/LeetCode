package com.rms.leetcode;

import java.util.*;

/**
 * @author Maosong Ran
 * @date 2019/01/18
 * @email maosongran@gmail.com
 */
public class Leetcode_530 {
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> q = new Stack();
//        q.offer(root);
        int min=-1, pre=0;
        TreeNode p = root;
        while (p != null || !q.isEmpty()) {
            while (p != null) {
                q.push(p);
                p = p.left;
            }

            if (!q.isEmpty()) {
                p = q.pop();
                if (min == -1) {
                    pre = p.val;
                    min = Integer.MAX_VALUE;
                } else {
                    min = p.val - pre < min ? p.val - pre : min;
                    pre = p.val;
                }
                p = p.right;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        new Leetcode_530().getMinimumDifference(root);
    }

}
