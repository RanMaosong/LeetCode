package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2018/12/28
 * @email maosongran@gmail.com
 */
public class Leetcode_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
