package com.rms.leetcode;

import java.awt.*;

public class Leetcode_61 {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return null;
        ListNode start = new ListNode(-1), end=start;
        start.next = head;
        int i;
        for (i=0; i < k && end.next != null; ++i)
            end = end.next;
        if (i != k)
            return rotateRight(head, k % i);
        else if (k== i && end.next == null)
            return head;
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = head;
        head = start.next;
        start.next = null;

        return head;
    }

    public static void main(String[] args) {

    }
}
