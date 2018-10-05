package com.rms.leetcode;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2018/10/05
 * @email maosongran@gmail.com
 */
public class LeetCode_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
            ArrayList<Integer> values = new ArrayList<Integer>();
            for (TreeNode node : nodes) {
                if (node != null) {
                    values.add(node.val);
                    tmp.add(node.left);
                    tmp.add(node.right);
                }
            }

            nodes = tmp;
            if (values.size() > 0)
                result.addFirst(values);
        }


        return result;
    }
}
