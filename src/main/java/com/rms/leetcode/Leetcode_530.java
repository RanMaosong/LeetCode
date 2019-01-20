package com.rms.leetcode;

import java.util.Arrays;

/**
 * @author Maosong Ran
 * @date 2019/01/18
 * @email maosongran@gmail.com
 */
public class Leetcode_530 {
    public int getMinimumDifference(TreeNode root) {
        int[] res = operation(root);
        return res[1];
    }
    private int[] operation(TreeNode root) {
        int[] res = new int[2];
        if (root.left == null && root.right == null) {
            res[0] = Integer.MAX_VALUE;
            res[1] = -1;
            return res;
        }
        int lmin=Integer.MAX_VALUE, gmin=Integer.MAX_VALUE;
        if (root.left != null) {
            int[] left = operation(root.left);
            if (left[1] != -1) {
                int diff = root.val - root.left.val;
                lmin = Math.abs(diff + left[0]) < Math.abs(diff) ? diff + left[0] : diff;
                gmin = Math.abs(lmin) < left[1] ? Math.abs(lmin) : left[1];
            } else {
                lmin = root.val - root.left.val;
                gmin = Math.abs(lmin);
            }
        }

        if (root.right != null) {
            int[] right = operation(root.right);
            if (right[1] != -1) {
                int diff = root.val - root.right.val;
                int tmp = Math.abs(diff + right[0]) < Math.abs(diff) ? diff + right[0] : diff;
                lmin = Math.abs(tmp) < Math.abs(lmin) ? tmp : lmin;
                tmp = Math.abs(lmin) < right[1] ? Math.abs(lmin) : right[1];
                gmin = gmin < tmp ? gmin : tmp;
            } else {
                int tmp = root.val - root.right.val;
                lmin = Math.abs(tmp) < Math.abs(lmin) ? tmp : lmin;
                tmp = Math.abs(lmin);
                gmin = gmin < tmp ? gmin : tmp;
            }
        }
        res[0] = lmin;
        res[1] = gmin;
        return res;
    }
}
