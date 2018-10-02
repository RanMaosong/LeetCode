package com.rms.leetcode;

public class LeetCode_35 {
    public int searchInsert(int[] nums, int target) {
        int i ;
        for (i=0; i <nums.length; ++i) {
            if (nums[i] >= target)
                return i;
        }

        return i;
    }

    public static void main(String[] args) {
        LeetCode_35 leetCode = new LeetCode_35();
        System.out.println(leetCode.searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(leetCode.searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(leetCode.searchInsert(new int[] {1,3,5,6}, 7));
        System.out.println(leetCode.searchInsert(new int[] {1,3,5,6}, 0));
    }
}
