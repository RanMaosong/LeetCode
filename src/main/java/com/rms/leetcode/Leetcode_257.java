package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2018/12/28
 * @email maosongran@gmail.com
 */
public class Leetcode_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        String node = "" + root.val;
        if (root.left != null)
            result.addAll(binaryTreePaths(root.left));

        if (root.right != null)
            result.addAll(binaryTreePaths(root.right));
        if (root.left == null && root.right == null) {
            result.add(node);
            return result;
        }


        int len = result.size();
        System.out.println(len);
        for (int i=0; i<len; ++i) {
            result.add(node +"->" + result.get(0));
            result.remove(0);
        }
        return result;
    }
}
