package com.rms.leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LeetCode_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergeList;

        if (l1.val < l2.val) {
            mergeList = l1;
            l1 = l1.next;
        } else {
            mergeList = l2;
            l2 = l2.next;
        }
        ListNode tail = mergeList;
        while (l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 != null ? l1 : l2;
        return mergeList;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        LeetCode_21 leetcode = new LeetCode_21();
        ListNode l3 = leetcode.mergeTwoLists(l1, l2);
        while (l1 != null) {
            System.out.print(l1.val + "->");
            l1 = l1.next;
        }
        System.out.println("");
        while (l2 != null) {
            System.out.print(l2.val + "->");
            l2 = l2.next;
        }
        System.out.println("");
        while (l3 != null) {
            System.out.print(l3.val + "->");
            l3 = l3.next;
        }
    }
}
