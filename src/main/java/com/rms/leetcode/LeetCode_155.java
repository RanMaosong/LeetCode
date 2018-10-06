package com.rms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Maosong Ran
 * @date 2018/10/06
 * @email maosongran@gmail.com
 */
public class LeetCode_155 {
    Stack<Integer> stack;
    Stack<Integer> minValues;
    public LeetCode_155() {
        stack = new Stack<Integer>();
        minValues = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if (minValues.isEmpty() || x <= minValues.peek()) {
            minValues.push(x);
        }
    }

    public void pop() {
        if (stack.peek().equals(minValues.peek())) {
            stack.pop();
            minValues.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValues.peek();
    }

    public static void main(String[] args) {
        LeetCode_155 leetCode = new LeetCode_155();
        leetCode.push(-2);
        leetCode.push(0);
        leetCode.push(-3);
        leetCode.push(-3);
        leetCode.push(-3);
        System.out.println(leetCode.getMin());
        leetCode.pop();
        System.out.println(leetCode.top());
        System.out.println(leetCode.getMin());

    }
}
