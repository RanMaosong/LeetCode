package com.rms.leetcode;

import java.util.ArrayList;
import java.util.Queue;

/**
 * @author Maosong Ran
 * @date 2018/12/22
 * @email maosongran@gmail.com
 */
public class LeetCode_225 {
    ArrayList<Integer> queue;
    /** Initialize your data structure here. */
    public LeetCode_225() {
        queue = new ArrayList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int len = queue.size();
        for (int i =0; i < len-1; ++i)
        {
            queue.add(queue.remove(0));
        }

        return queue.remove(0);
    }

    /** Get the top element. */
    public int top() {
        int len = queue.size();
        int result = 0;
        for (int i =0; i < len; ++i)
        {
            result = queue.remove(0);
            queue.add(result);
        }

        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }

    public static void main(String[] args) {
        LeetCode_225 lt = new LeetCode_225();
        lt.push(4);
        lt.push(5);;
        System.out.println(lt.pop());
        System.out.println(lt.pop());
    }
}
