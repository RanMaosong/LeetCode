package com.rms.leetcode;

import java.util.Stack;

/**
 * @author Maosong Ran
 * @date 2018/12/22
 * @email maosongran@gmail.com
 */
public class LeetCode_232 {
    Stack<Integer> in;
    Stack<Integer> out;
    int i;
    /** Initialize your data structure here. */
    public LeetCode_232() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
        i = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
        ++i;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        --i;
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return i ==0;
    }
}
