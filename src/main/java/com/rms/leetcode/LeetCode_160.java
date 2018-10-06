package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/10/06
 * @email maosongran@gmail.com
 */
public class LeetCode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        // 等长法
        ListNode a = headA, b = headB;
        int m = 0, n = 0;
        while (a != null) {
            ++m;
            a = a.next;
        }

        while (b != null) {
            ++n;
            b = b.next;
        }
        a = headA;
        b = headB;
        if (m > n) {
            for(int i=0; i < m-n; ++i) {
                a = a.next;
            }
        } else {
            for(int i=0; i < n-m; ++i) {
                b = b.next;
            }
        }

        while (a != null && b != null) {
            if (a == b)
                return a;
            a = a.next;
            b = b.next;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 双指针
        if (headA == null || headB == null)
            return null;
        ListNode a = headA, b = headB;
        while (a != null && b != null) {
            System.out.println(a.val + "," + b.val);
            if (a == b)
                return a;
            a = a.next;
            b = b.next;
            if (a == b)
                return a;
            if (a == null)
                a = headB;
            if (b == null)
                b = headA;


        }

        return null;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(new int[] {3});
        ListNode b = new ListNode(new int[] {2, 3});

        LeetCode_160 leetCode = new LeetCode_160();
        System.out.println(leetCode.getIntersectionNode2(a, b));
    }
}
