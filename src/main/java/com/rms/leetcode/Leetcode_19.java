package com.rms.leetcode;

public class Leetcode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1), front = res, tail=res;
        res.next = head;
        for (int i=0; i <= n; ++i) {
            tail = tail.next;
        }

        while (tail != null) {
            front = front.next;
            tail = tail.next;
        }



        return res.next;
    }

    public static void main(String[] args) {

    }
}
