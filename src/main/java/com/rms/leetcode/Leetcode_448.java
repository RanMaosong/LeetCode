package com.rms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2019/01/14
 * @email maosongran@gmail.com
 */
public class Leetcode_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i <nums.length; ++i) {
            int index = Math.abs(nums[i]);
            nums[index-1] = -Math.abs(nums[index-1]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0; i <nums.length; ++i) {
            if (nums[i] >= 0) {
                result.add(i+1);
            }
        }

        return result;
    }
}
