package com.rms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode res = null;
        while (head != null) {
            if (set.contains(head)) {
                res = head;
                break;
            }
            set.add(head);
            head = head.next;
        }

        return res;
    }

    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
