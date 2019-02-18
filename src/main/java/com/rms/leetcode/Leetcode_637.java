package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2019/02/18
 * @email maosongran@gmail.com
 */
public class Leetcode_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null)
            return  res;
        List<TreeNode> layer = new ArrayList<>();
        layer.add(root);
        while (!layer.isEmpty()) {
            double sum = 0.0;
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : layer) {
                sum += node.val;
                if (node.left != null)
                    next.add(node.left);
                if (node.right != null)
                    next.add(node.right);
            }
            res.add(sum / layer.size());
            layer = next;
        }

        return res;
    }
}
