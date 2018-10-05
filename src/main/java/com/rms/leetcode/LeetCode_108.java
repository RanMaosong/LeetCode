package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/05
 * @email maosongran@gmail.com
 */
public class LeetCode_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head = createTree(nums, 0, nums.length);
        return head;
    }

    private TreeNode createTree(int[] nums, int i, int j) {
        if (i == j)
            return null;
        int mid = (i + j) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createTree(nums, i, mid);
        node.right = createTree(nums, mid + 1, j);
        return node;
    }

    public static void main(String[] args) {
        LeetCode_108 leetCode = new LeetCode_108();

        leetCode.sortedArrayToBST(new int[] {1, 2, 3, 4});
    }
}
