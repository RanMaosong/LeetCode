package com.rms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maosong Ran
 * @date 2019/01/14
 * @email maosongran@gmail.com
 */

class Node1 {
    public int val;
    public List<Node1> children;

    public Node1() {}

    public Node1(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class Leetcode_429 {
    public List<List<Integer>> levelOrder(Node1 root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        List<Node1> parent = new ArrayList<>();
        List<Node1> children = new ArrayList<>();

        parent.add(root);

        while (!parent.isEmpty()) {
            List<Integer> node = new ArrayList<>();
            for (Node1 a : parent) {
                node.add(a.val);
                children.addAll(a.children);
            }
            result.add(node);
            node.clear();
            parent.clear();
            parent.addAll(children);
            children.clear();

        }

        return result;

    }
}
