package com.learn.algorithm.list;

/**
 * Leetcode 141. Linked List Cycle
 *
 * @author guoxingyong
 * @data 2019/3/28 10:52
 */
public class CycleList {
    /**
     *
     * @param head 头节点
     * @return true链表有环，false，链表没有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (true) {
            //一个快指针一个慢指针，慢指针就一步，快指针就两步，如果有环快指针会追上慢的相等
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (fastNode == null || fastNode.next == null) {
                return false;
            }
            if (slowNode == fastNode) {
                return true;
            }
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
