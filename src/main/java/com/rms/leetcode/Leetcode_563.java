package com.rms.leetcode;

import java.util.Arrays;

public class Leetcode_563 {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        operation(root);
        return tilt;
    }
    private int operation(TreeNode root) {
        if (root == null)
            return 0;
        int left = operation(root.left), right = operation(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;

    }
}
