package com.learn.algorithm.list;

/**
 * leetcode 206 Reverse Linked List
 * @author guoxingyong
 * @data 2019/3/28 9:04
 */
public class ReversalList {
    /**
     * 个人答案使用了四个节点
     *
     * @param head 头节点
     * @return 翻转后的头节点
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1, p2, p3;
        ListNode pri = null;
        p1 = head;
        p2 = head.next;
        p3 = head.next.next;
        while (p3 != null) {
            p1.next = pri;
            pri = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p1.next = pri;
        p2.next = p1;
        return p2;
    }

    /**
     * 使用三个指针
     * @param head 头节点
     * @return 翻转后的头节点
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1, p2, pri;
        p1 = head;
        p2 = head.next;
        pri = null;
        while (p2 != null) {
            p1.next = pri;
            pri = p1;
            p1 = p2;
            p2 = p2.next;
        }
        p1.next=pri;
        return p1;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            if (next != null) {
                return val + "," + next.toString();
            }
            return val + "";
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(7);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(1);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode1 = reverseList2(listNode);
        System.out.println();
    }
}
