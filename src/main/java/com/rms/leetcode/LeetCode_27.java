package com.rms.leetcode;

public class LeetCode_27 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i=0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        LeetCode_27 leetcode = new LeetCode_27();
        System.out.println(leetcode.removeElement(new int[]{1,1,2}, 3));
        int[] a = new int[]{0,1,2,2,3,0,4,2};
        int len = leetcode.removeElement(a, 2);
        System.out.println(len);
        for (int i = 0; i < len; ++i) {
            System.out.print(a[i] + ", ");
        }
    }
}
