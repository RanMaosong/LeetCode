package com.rms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Maosong Ran
 * @date 2019/02/20
 * @email maosongran@gmail.com
 */
public class Leetcode_671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        int min = root.val, second = min;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val > min && second != min)
                second = node.val < second ? node.val : second;
            if (node.val > min && second == min)
                second = node.val;

            if (node.left != null) {
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return min == second ? -1 : second;
    }
}
