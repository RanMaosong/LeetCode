package com.rms.leetcode;

import java.util.Arrays;

public class Leetcode_34 {
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length-1);
    }
    public int[] searchRange(int[] nums, int target, int i, int j) {
//        System.out.print(i + " " + j + " ");
        int[] res = new int[]{-1, -1};
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                int[] left = searchRange(nums, target, i, mid-1), right = searchRange(nums, target, mid+1, j);
                if (left[0] == -1)
                    res[0] = mid;
                else
                    res[0] = left[0];

                if (right[0] == -1)
                    res[1] = mid;
                else
                    res[1] = right[1];
                return res;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
//        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
        System.out.print(Arrays.toString(new Leetcode_34().searchRange(new int[]{2, 2}, 2)));
    }
}
