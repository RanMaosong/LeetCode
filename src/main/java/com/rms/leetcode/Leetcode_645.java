package com.rms.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Maosong Ran
 * @date 2019/02/18
 * @email maosongran@gmail.com
 */
public class Leetcode_645 {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                res[0] = num;
            else
                set.add(num);
        }

        int n = nums.length;
        for (int i=1; i <= n; ++i) {
            if (!set.contains(i)) {
                res[1] = i;
                return res;
            }
        }
        return res;
    }

    public int[] findErrorNums2(int[] nums) {
        int[] res = new int[2];
        int[] index = new int[nums.length+1];
        int sum = 0, n = nums.length;
        for (int num : nums) {
            if (index[num] != 0)
                res[0] = num;
            else {
                index[num] = num;
                sum += num;
            }
        }

        res[1] = n * (n+1) / 2 - sum;
        return res;

    }
}
