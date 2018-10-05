package com.rms.leetcode;

public class LeetCode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n - 1, len = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[len] = nums1[i];
                --i;
            } else {
                nums1[len] = nums2[j];
                --j;
            }

            --len;
        }

        for (; j>=0; --j, --len) {
            nums1[len] = nums2[j];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 0, 0, 0};
        int[] b = new int[] {2, 5, 6};

        LeetCode_88 leetCode = new LeetCode_88();
        leetCode.merge(a, 3, b, 3);

        for(int tmp : a) {
            System.out.println(tmp);
        }
    }
}
