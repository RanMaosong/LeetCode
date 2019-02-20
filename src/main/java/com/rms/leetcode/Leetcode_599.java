package com.rms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }

        int flag = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i=0; i < list2.length; ++i) {
            if (map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if (sum < flag) {
                    list.clear();;
                    flag = sum;
                    list.add(list2[i]);
                } else if (sum == flag) {
                    list.add(list2[i]);
                }
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
