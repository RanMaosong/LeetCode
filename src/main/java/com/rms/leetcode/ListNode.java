package com.rms.leetcode;



public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode(int[] nums) {
        this.val = nums[0];
        int len = nums.length;
        ListNode tail = this;

        for (int i = 1; i < len; ++i) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }
    }

    public String toString() {
        return  val + "";
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        ListNode tmp = this;
        while (tmp != null) {
            sb.append(tmp.val);
            tmp = tmp.next;
            if (tmp != null) {
                sb.append("->");
            }
        }

        return sb.toString();
    }
}
