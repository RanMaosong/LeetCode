package com.rms.leetcode;

public class LeetCode_53 {
    /**
     * O(n^2)
     * @param nums
     * @return
     */
    int[][] table;
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        table = new int[len][len];
        int max = nums[0];
        for (int i=0; i < len; ++i) {
            table[i][i] = nums[i];
            max = max > table[i][i] ? max:table[i][i];
            for (int j=i+1; j<len; ++j) {
                table[i][j] = table[i][j-1] + nums[j];
                max = max > table[i][j] ? max:table[i][j];
            }
        }

        return max;
    }

    /**
     * bp
     * O(N)
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int n = nums[0];
        for (int i=1; i<nums.length; ++i) {
            n = n < 0 ? nums[i] : n + nums[i];
            max = Math.max(n, max)
        }

        return max;

    }

    public static void main(String[] args) {
        LeetCode_53 leetCode = new LeetCode_53();
        System.out.println(leetCode.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
