package com.rms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Maosong Ran
 * @date 2019/02/18
 * @email maosongran@gmail.com
 */
public class Leetcode_653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode tmp = root.left;
        List<Integer> list = new ArrayList<>();
        while (!s.isEmpty()) {
            while (tmp != null) {
                s.add(tmp);
                tmp = tmp.left;
            }
            TreeNode pre = s.pop();
            list.add(pre.val);
            tmp = pre.right;
            while (tmp != null) {
                s.add(tmp);
                tmp = tmp.left;
            }
        }
        int i=0, j=list.size()-1;
        while (i < j) {
            int num1 = list.get(i), num2 = list.get(j);
            if (num1 + num2 > k)
                --j;
            else if (num1 + num2 < k)
                ++i;
            else
                return true;
        }
        return false;
    }
}
