package com.rms.leetcode;

public class LeetCode_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        ListNode newList = null;
        ListNode tail = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;

            if (temp.val != val) {
                if (newList == null) {
                    newList = temp;
                    tail = newList;
                } else {
                    tail.next = temp;
                    tail = tail.next;
                }

                tail.next = null;
            }
        }
        return newList;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
    public static void main(String[] args) {

        LeetCode_203 leetCode = new LeetCode_203();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next.next = new ListNode(6);

        ListNode temp = listNode;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        listNode = leetCode.removeElements(listNode, 6);
        System.out.println();
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
}
