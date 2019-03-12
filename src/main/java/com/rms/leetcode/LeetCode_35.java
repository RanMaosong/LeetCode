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
    public int searchInsert1(int[] nums, int target) {
        if (target < nums[0])
            return 0;
        else if (target > nums[nums.length-1])
            return nums.length;
        int i =0, j = nums.length - 1, mid=0;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] > target)
                j = mid-1;
            else if (nums[mid] < target)
                i = mid+1;
            else
                return mid;
        }

        return nums[mid] > target?mid:mid+1;
    }

    public static void main(String[] args) {
        LeetCode_35 leetCode = new LeetCode_35();
        System.out.println(leetCode.searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(leetCode.searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(leetCode.searchInsert(new int[] {1,3,5,6}, 7));
        System.out.println(leetCode.searchInsert(new int[] {1,3,5,6}, 0));
    }
}
