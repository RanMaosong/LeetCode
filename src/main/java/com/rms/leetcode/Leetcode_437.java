package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/01/14
 * @email maosongran@gmail.com
 */
public class Leetcode_437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return  operation(root, 0, sum, true);
    }

    private int operation(TreeNode root, int current, int sum, boolean flag) {
//        System.out.println(current);
        if (root == null)
            return 0;
        int result = 0;
        if (current + root.val == sum) {
            ++result;
            System.out.println(current + " " + root.val);
        }

        if (flag) {
            return operation(root.right, current + root.val, sum, false) +
                    operation(root.left, root.val + current, sum, false) + result;
        } else {
            return  operation(root, 0, sum, true) +
                    operation(root.right, current + root.val, sum, false) +
                    operation(root.left, root.val + current, sum, false) + result;
        }


    }
}
