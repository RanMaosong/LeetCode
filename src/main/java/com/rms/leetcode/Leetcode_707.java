package com.rms.leetcode;

/**
 * @author Maosong Ran
 * @date 2019/02/21
 * @email maosongran@gmail.com
 */
public class Leetcode_707 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.toString();
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.toString();
        System.out.println(linkedList.get(1));          //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));
    }
}

class MyLinkedList {
    class LinkNode {
        int val;
        LinkNode next;
        public LinkNode() {

        }

        public LinkNode(int val) {
            this.val = val;
        }
    }

    LinkNode list;
    int n = 0;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        list = new LinkNode();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        toString();
        if (index < n) {
            int i=0;
            LinkNode tmp = list;
            while (i <= index) {
                tmp = tmp.next;
                ++i;
            }
            return tmp.val;
        } else {
            return -1;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        LinkNode node = new LinkNode(val);
        node.next = list.next;
        list.next = node;
         ++n;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        LinkNode tmp = list;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        LinkNode node = new LinkNode(val);
        node.next = tmp.next;
        tmp.next = node;
        ++n;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > n)
            return ;
        LinkNode tmp = list;
        int i=0;
        while (i < index) {
            tmp = tmp.next;
            ++i;
        }
        LinkNode node = new LinkNode(val);
        node.next = tmp.next;
        tmp.next = node;
        ++n;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= n)
            return;
        LinkNode tmp = list;
        int i=0;
        while (i < index) {
            tmp = tmp.next;
            ++i;
        }
        if (tmp.next.next == null)
            tmp.next = null;
        else
            tmp.next = tmp.next.next;
        --n;
    }

    public String toString() {
        LinkNode node = list.next;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.val + " ");
            node = node.next;
        }
        sb.append("]");
        System.out.println(sb.toString() + " " + n);
        return sb.toString();
    }
}
