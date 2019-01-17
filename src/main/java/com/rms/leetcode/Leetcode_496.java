package com.rms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i < nums2.length; ++i) {
            map.put(nums2[i], i);
        }

        int[] res = new int[nums1.length];
        for (int i=0; i < nums1.length; ++i ) {
            int index = map.get(nums1[i]);
            boolean flag = true;
            for (int j=index+1; j <nums2.length; ++j) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    flag = false;
                    break;
                }
            }

            if (flag)
                res[i] = -1;

        }

        return res;
    }
}
