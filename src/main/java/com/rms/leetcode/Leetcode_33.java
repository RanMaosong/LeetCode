package com.rms.leetcode;

import java.lang.annotation.Target;

public class Leetcode_33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int i, int j) {
        // 有序
        if (j < i) {
            return -1;
        } else if (nums[j] > nums[i]) {
            while (i <= j) {
                int mid = (i + j) / 2;
                if (nums[mid] < target) {
                    i = mid + 1;
                } else if (nums[mid] > target) {
                    j = mid - 1;
                } else {
                    return mid;
                }
            }

            return -1;
        } else {
            int mid = (i + j) / 2;
            if (nums[mid] == target)
                return mid;
            int m = search(nums, target, i, mid-1);
            if (m == -1) {
                return search(nums, target, mid + 1, j);
            } else {
                return m;
            }
        }
    }
    public int search1(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int i = 0, l = nums.length - 1;
        while (i <= l) {
            int mid = (i + l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < nums[l]) {
                if (nums[mid] < target && target <= nums[l]) {
                    i = mid + 1;
                } else {
                    l = mid - 1;
                }

            } else {
                if (nums[i] <= target && target <= nums[mid]) {
                    l = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
