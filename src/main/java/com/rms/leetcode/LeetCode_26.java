package com.rms.leetcode;

public class LeetCode_26 {
    public int removeDuplicates(int[] nums) {
        int currentIndex = 0;
        for (int i=1; i<nums.length; ++i) {
            if (nums[currentIndex] != nums[i]) {
                if (i - currentIndex != 1) {
                    nums[currentIndex + 1] = nums[i];
                }
                currentIndex++;
            }
        }

        return currentIndex + 1;
    }

    public static void main(String[] args) {
        LeetCode_26 leetcode = new LeetCode_26();
        System.out.println(leetcode.removeDuplicates(new int[]{1,1,2}));
        int[] a = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len = leetcode.removeDuplicates(a);
        System.out.println(len);
        for (int i = 0; i < len; ++i) {
            System.out.print(a[i] + ", ");
        }
    }
}
