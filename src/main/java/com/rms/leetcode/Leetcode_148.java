package com.rms.leetcode;

public class Leetcode_148 {
    public ListNode sortList(ListNode head) {
        return operation(head, null);
    }

    private ListNode operation(ListNode start, ListNode end) {
        if (start == end || start.next == end)
            return start;
        ListNode l = start, r = start, mid = start, cur = start.next;
        while (cur != end) {
            ListNode pre = cur;
            cur = cur.next;
            if (pre.val < mid.val) {
                pre.next = l;
                l = pre;
            } else {
                r.next = pre;
                r = pre;
            }
        }

        r.next = end;
        l = operation(l, mid);
        mid.next = operation(mid.next, r.next);

        return l;
    }

    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head, pre=null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = pre.next;
        pre.next = null;

        return merge(sortList1(head), sortList1(fast));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head=null, tail=null;
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

        if (l2 != null)
            l1 = l2;
        tail.next = l1;

        return head;

    }

    public static void main(String[] args) {
        ListNode list = new ListNode(4);
        list.next = new ListNode(2);
        list.next.next = new ListNode(1);
        list.next.next.next = new ListNode(3);
        System.out.println(new Leetcode_148().sortList1(list).show());
    }
}
