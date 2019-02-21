package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_705 {
}

class MyHashSet {
    List<Integer> map;
    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new ArrayList<>();
    }

    public void add(int key) {
        if (!contains(key))
            map.add(key);
    }

    public void remove(int key) {
        for (int i=0; i < map.size(); ++i) {
            if (map.get(i) == key) {
                map.remove(i);
                break;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map.contains(key);
    }
}
