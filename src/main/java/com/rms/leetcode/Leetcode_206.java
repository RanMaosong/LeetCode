package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/11/02
 * @email maosongran@gmail.com
 */
public class Leetcode_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode next = head;
        head = head.next;
        next.next = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = next;
            next = tmp;
        }

        return next;
    }
}
