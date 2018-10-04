package com.rms.leetcode;

public class LeetCode_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode first = head, second = first.next;
        while (second != null) {
            if (first.val == second.val) {
                second = second.next;
                first.next = second;
            } else {
                first = second;
                second = second.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode_83 leetCode = new LeetCode_83();
        ListNode node1 = new ListNode(new int[] {1, 1, 2});
        System.out.println(leetCode.deleteDuplicates(node1));

        ListNode node2 = new ListNode(new int[] {1, 1, 2, 3, 3});
        System.out.println(leetCode.deleteDuplicates(node2));
    }
}
