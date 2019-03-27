package com.learn.algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 146 LRU Cache
 *
 * @author guoxingyong
 * @data 2019/3/27 9:03
 */
public class LRUCache {
    /**
     * 头节点
     */
    private Node head;
    /**
     * 尾节点
     */
    private Node tail;
    /**
     * 当前cache数量
     */
    private int count;
    /**
     * 阈值
     */
    private int threshold;
    private Map<Integer, Node> nodeMap;

    public LRUCache(int capacity) {
        threshold = capacity;
        nodeMap = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        //如果k不存在直接返回-1
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }

        removeCurrentNode(node);
        toFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node;
        if (nodeMap.containsKey(key)) {
            //当该值已经存在就更新该值，把他从之前的节点位置移动到第一个节点
            node = nodeMap.get(key);
            node.value = value;
            removeCurrentNode(node);
        } else {
            node = new Node();
            node.key = key;
            node.value = value;
            //当达到阈值时，需要删除掉最后一个值
            if (count == threshold) {
                Node deleteNode = tail.previous;
                Node previous = deleteNode.previous;
                previous.next = tail;
                tail.previous = previous;
                nodeMap.remove(deleteNode.key);
            } else {
                count++;
            }
            nodeMap.put(key, node);
        }
        toFirst(node);
    }

    /**
     *  把当前节点的前置节点的后置节点的指针指向当前节点的后置节点
     *  把当前节点的后置节点的前置节点的指针指向当前节点的前置节点
     * @param node 当前节点
     */
    private void removeCurrentNode(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        previous.next = next;
        next.previous = previous;
    }


    /**
     * 移动当前节点到第一个节点
     * @param node 需要移动的节点
     */
    private void toFirst(Node node) {
        Node headNext = head.next;
        headNext.previous = node;
        head.next = node;
        node.previous = head;
        node.next = headNext;
    }

    private class Node {
        private Integer key;
        private Node previous;
        private Node next;
        private Integer value;
    }

    public static void main(String[] args) {
/*        ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],
[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]*/

        LRUCache LRUCache = new LRUCache(10);
        LRUCache.put(10, 13);
        LRUCache.put(3, 17);
        LRUCache.put(6, 11);
        LRUCache.put(10, 5);
        LRUCache.put(9, 10);
        System.out.println(LRUCache.get(13));
        LRUCache.put(2, 19);
        System.out.println(LRUCache.get(2));
        System.out.println(LRUCache.get(3));
        LRUCache.put(5, 25);
        System.out.println(LRUCache.get(8));
        LRUCache.put(9, 22);
        LRUCache.put(5, 5);
        LRUCache.put(1, 30);
        System.out.println(LRUCache.get(11));
        LRUCache.put(9, 12);
        System.out.println(LRUCache.get(7));
        System.out.println(LRUCache.get(5));
        System.out.println(LRUCache.get(8));
        System.out.println(LRUCache.get(9));
        LRUCache.put(4, 30);
        LRUCache.put(9, 3);
        System.out.println(LRUCache.get(9));
        System.out.println(LRUCache.get(10));
        System.out.println(LRUCache.get(10));
        LRUCache.put(6, 14);
        LRUCache.put(3, 1);
        System.out.println(LRUCache.get(3));
        LRUCache.put(10, 11);
        System.out.println(LRUCache.get(8));
        LRUCache.put(2, 14);
        System.out.println(LRUCache.get(1));
        LRUCache.put(4, 1);
        System.out.println(LRUCache.get(2));
    }
}
