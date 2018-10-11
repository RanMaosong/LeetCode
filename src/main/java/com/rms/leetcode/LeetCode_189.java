package com.rms.leetcode;

import java.util.Arrays;

/**
 * @author Maosong Ran
 * @date 2018/10/07
 * @email maosongran@gmail.com
 */
public class LeetCode_189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(nums, 0, nums.length-1);
        swap(nums, 0, k-1);
        swap(nums, k, nums.length-1);

    }

    private void swap(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            ++i;
            --j;
        }
    }
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int count = 0;
        for (int i=0; count < len; ++i) {
            int pre = nums[i];
            int current = i;
            do {
                int next = (current + k) % len;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                current = next;
                count++;
            } while (current != i);
        }
    }

    public static void main(String[] args) {
        LeetCode_189 leetCode = new LeetCode_189();
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(a));
        leetCode.rotate2(a, 3);
        System.out.println(Arrays.toString(a));
    }
}
