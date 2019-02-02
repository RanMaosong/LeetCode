package com.rms.leetcode;

import java.util.List;

class Node1 {
    public int val;
    public List<Node1> children;

    public Node1() {}

    public Node1(int _val,List<Node1> _children) {
        val = _val;
        children = _children;
    }
};

public class Leetcode_559 {
    public int maxDepth(Node1 root) {
        if (root == null)
            return 0;
        int depth = 0;
        for (Node1 node : root.children) {
            int tmp = maxDepth(node);
            depth = depth > tmp ? depth : tmp;
        }

        return depth+1;
    }
}
