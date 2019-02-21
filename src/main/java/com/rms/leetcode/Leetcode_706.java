package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_706 {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // 返回 1
        hashMap.get(3);            // 返回 -1 (未找到)
        hashMap.put(2, 1);         // 更新已有的值
        hashMap.get(2);            // 返回 1
        hashMap.remove(2);         // 删除键为2的数据
        hashMap.get(2);            // 返回 -1 (未找到)
    }
}

class MyHashMap {
    class MapNode {
        List<Integer> list;
        public MapNode() {
            list = new ArrayList<>();
        }
    }

    MapNode[] keys, vals;
    int n = 100;
    /** Initialize your data structure here. */
    public MyHashMap() {
        keys = new MapNode[n];
        vals = new MapNode[n];
        for (int i=0; i < n ; ++i) {
            keys[i] = new MapNode();
            vals[i] = new MapNode();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        int index = key % n;
        MapNode node = keys[index];
//        System.out.println(key + " " + value + " " + (node == null));
        for (int i =0; i < node.list.size(); ++i) {
            if (node.list.get(i) == key) {
                node.list.remove(i);
                vals[index].list.remove(i);
            }
        }

        node.list.add(key);
        vals[index].list.add(value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % n;
        MapNode node = keys[index];
        for (int i =0; i < node.list.size(); ++i) {
            if (node.list.get(i) == key) {
                return vals[index].list.get(i);
            }
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % n;
        MapNode node = keys[index];
        for (int i =0; i < node.list.size(); ++i) {
            if (node.list.get(i) == key) {
                node.list.remove(i);
                vals[index].list.remove(i);
            }
        }
    }
}
