package com.rms.leetcode;


import java.util.ArrayList;
import java.util.List;

class Node2 {
    public int val;
    public List<Node2> children;

    public Node2() {}

    public Node2(int _val,List<Node2> _children) {
        val = _val;
        children = _children;
    }
};
public class Leetcode_589 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node2 root) {
        if (root == null)
            return res;
        res.add(root.val);
        for (Node2 node : root.children) {
            preorder(node);
        }

        return res;
    }
}
