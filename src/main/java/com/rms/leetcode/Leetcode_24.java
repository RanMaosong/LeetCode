package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/11/02
 * @email maosongran@gmail.com
 */
public class Leetcode_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null ||head.next == null)
            return head;
        ListNode first = head, second = head.next, third = second.next;
        head = second;
        second.next = first;

        first.next = swapPairs(third);

        return head;

    }
}
