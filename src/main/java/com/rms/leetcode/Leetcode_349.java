package com.rms.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Maosong Ran
 * @date 2019/01/10
 * @email maosongran@gmail.com
 */
public class Leetcode_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int a : nums1) {
            set1.add(a);
        }

        for (int a : nums2) {
            set2.add(a);
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int a : set1) {
            if (set2.contains(a))
                list.add(a);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }
        return result;


    }
}
