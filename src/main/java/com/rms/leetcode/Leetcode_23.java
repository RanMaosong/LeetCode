package com.rms.leetcode;

public class Leetcode_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        ListNode res = null;
        for (int i=0; i < lists.length; ++i) {
            if (lists[i] != null && res == null)
                res = lists[i];
            else if (lists[i] != null && res != null)
                res = merge(res, lists[i]);
        }

        return res;

    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (head == null) {
                    head = l1;
                    tail = l1;
                } else {
                    tail.next = l1;
                    tail = l1;
                }

                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    tail = l2;
                } else {
                    tail.next = l2;
                    tail = l2;
                }

                l2 = l2.next;
            }
        }

        if (l1 != null)
            tail.next = l1;
        if (l2 != null)
            tail.next = l2;


        return head;
    }

    public static void main(String[] args) {

    }
}
