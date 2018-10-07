package com.rms.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Maosong Ran
 * @date 2018/10/06
 * @email maosongran@gmail.com
 */
public class LeetCode_169 {
    public int majorityElement(int[] nums) {
        /**
         * O(n^2)
         *  Time Limit Exceeded
         */

        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            int count = 0;
            for(int j = 0; j < nums.length; ++j) {
                if (nums[i] == nums[j])
                    ++count;
            }

            max = Math.max(max, count);
            if (max > nums.length / 2)
                return nums[i];

        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        /**
         * O(n) O(n)
         */
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int i=0; i < nums.length; ++i) {
            Integer num = count.get(nums[i]);
            if (num == null)
                num = 1;
            else
                ++num;

            if (num > nums.length / 2)
                return nums[i];
            count.put(nums[i], num);
        }

        return nums[0];
    }
    public int majorityElement3(int[] nums) {
        /**
         * O(nlgn)
         * O(1) or O(n)
         * sort
         */
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement4(int[] nums) {
        return divideAndConquer(nums, 0, nums.length-1);
    }

    private int divideAndConquer(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        else {
            int mid = (left + right)/2;
            int leftMajority = divideAndConquer(nums, left, mid);
            int rightMajority = divideAndConquer(nums, mid + 1, right);
//            System.out.println(leftMajority + "->" + rightMajority);

            if (leftMajority == rightMajority)
                return leftMajority;

            int leftCount = 0;
            int rightCount = 0;
            for(int i=left; i <= right; ++i) {
                if (nums[i] == leftMajority)
                    ++leftCount;
                else if (nums[i] == rightMajority) {
                    ++rightCount;
                }
            }
//            System.out.println(leftMajority + ":" + leftCount + ", " + rightMajority + ": " + rightCount);
            return leftCount > rightCount ? leftMajority : rightMajority;

        }
    }

    public int majorityElement5(int[] nums) {
        int  count = 0;
        Integer candiate = null;
        for(int num : nums) {
            if (count == 0) {
                candiate = num;
            }

            count += (candiate == num) ? 1 : -1;
        }

        return candiate;
    }

    public static void main(String[] args) {
        LeetCode_169 leetCode = new LeetCode_169();
        System.out.println(leetCode.majorityElement5(new int[]{6, 5, 5}));
    }

}



