package com.rms.leetcode;

public class Leetcode_606 {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t == null)
            return sb.toString();
        sb.append(t.val);
        String left = tree2str(t.left), right = tree2str(t.right);
        if (left.length() > 0 || right.length() > 0) {
            sb.append("(");
            sb.append(left);
            sb.append(")");
        }

        if (right.length() > 0) {
            sb.append("(");
            sb.append(right);
            sb.append(")");
        }

        return sb.toString();
    }
}
