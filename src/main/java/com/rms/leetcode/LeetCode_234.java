package com.rms.leetcode;

import java.util.Stack;

/**
 * @author Maosong Ran
 * @date 2018/12/22
 * @email maosongran@gmail.com
 */
public class LeetCode_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        if (head.next == null)
            return true;
        Stack<Integer> s = new Stack<Integer>();
        ListNode tmp = head;
        while (tmp != null) {
            s.push(tmp.val);
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp != null) {
            if (tmp.val != s.pop())
                return false;
            tmp = tmp.next;
        }

        return true;
    }
}
