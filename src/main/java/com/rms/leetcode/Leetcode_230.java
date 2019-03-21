package com.rms.leetcode;

import java.util.Stack;

public class Leetcode_230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (p != null || !s.empty()) {
            if (p != null) {
                s.push(p);
                p = p.left;
            }
            else {
                p = s.pop();
                System.out.print(p.val + " ");
                --k;

                if (k == 0)
                    return p.val;
                p = p.right;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
