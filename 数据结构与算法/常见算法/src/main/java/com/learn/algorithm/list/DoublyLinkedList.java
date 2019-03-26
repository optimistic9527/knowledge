package com.learn.algorithm.list;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 *  双向链表基本实现
 * @author guoxingyong
 * @data 2019/3/26 21:07
 */
public class DoublyLinkedList<T> implements Collection<T> {
    private Node<T> head;
    private Node<T> tail;
    private int count;

    public DoublyLinkedList() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.previous = head;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(T t) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.t, t)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoublyLinkedList{");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.t);
            current = current.next;
            if (current != null) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean add(T t) {
        if (t == null) {
            return false;
        }
        Node<T> newNode = new Node<>(t);
        Node<T> previous = tail.previous;
        previous.next = newNode;
        newNode.previous = previous;
        newNode.next = tail;
        tail.previous = newNode;
        count++;
        return true;
    }

    @Override
    public boolean remove(T t) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.t, t)) {
                Node<T> previous = current.previous;
                Node<T> next = current.next;
                previous.next = next;
                next.previous = previous;
                count--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean addFirst(T t) {
        if (t == null) {
            return false;
        }
        Node<T> newNode = new Node<>(t);
        Node<T> next = head.next;
        newNode.previous = head;
        newNode.next = next;
        next.previous = newNode;
        head.next = newNode;
        count++;
        return true;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private class Node<T> {
        private Node<T> previous;
        private Node<T> next;
        private T t;

        public Node(T t) {
            this.t = t;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add("aaaa");
        doublyLinkedList.add("bbb");
        doublyLinkedList.add("ccc");
        System.out.println(doublyLinkedList.size());
        doublyLinkedList.add("ddd");
        doublyLinkedList.add("eee");
        doublyLinkedList.add("fff");
        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.remove("ccc");
        System.out.println(doublyLinkedList.size());
        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.addFirst("tttt");
        System.out.println(doublyLinkedList.toString());
        System.out.println(doublyLinkedList.contains("eee"));
        doublyLinkedList.add("ccc");
        System.out.println(doublyLinkedList.toString());
        System.out.println(doublyLinkedList.size());
    }
}
