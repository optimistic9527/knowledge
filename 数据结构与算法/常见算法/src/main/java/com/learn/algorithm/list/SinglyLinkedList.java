package com.learn.algorithm.list;


import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Objects;


/**
 * 单向链表的数据结构
 *
 * @author guoxingyong
 * @data 2019/3/24 10:01
 */
public class SinglyLinkedList<E> implements Collection<E> {
    private Node<E> head;
    private Node<E> tail;
    private int count;

    public SinglyLinkedList() {
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(E e) {
        if(e==null){
            return false;
        }
        Node<E> current = head;
        while (current!=null){
            if(current.e.equals(e)){
                return true;
            }
            current=current.next;
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            return false;
        }
        Node<E> newNode = new Node<>(null, e);
        if (head == null) {
            head = newNode;
        } else {
            if (tail != null) {
                tail.next = newNode;
                tail = newNode;
            }else {
                tail = newNode;
                head.next=tail;
            }
        }
        count++;
        return true;
    }

    @Override
    public boolean remove(E e) {
        if (e == null || head == null) {
            return false;
        }
        Node<E> current = head;
        Node<E> previous = head;
        while (current.next != null) {
            if (Objects.equals(current.e, e)) {
                previous.next = current.next;
                count--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }


    @Override
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        }
        Node<E> newNode = new Node<>(null, e);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        count++;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("SinglyLinkedList{");

        Node<E> current = head;
        while (current!=null){
            sb.append(current.e);
            current=current.next;
            if(current!=null){
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @AllArgsConstructor
    @ToString
    private class Node<E> {
        private Node<E> next;
        private E e;
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> stringSinglyLinkedList = new SinglyLinkedList<>();
        stringSinglyLinkedList.add("aaaa");
        stringSinglyLinkedList.add("bbb");
        stringSinglyLinkedList.add("ccc");
        stringSinglyLinkedList.add("ddd");
        stringSinglyLinkedList.add("eee");
        stringSinglyLinkedList.add("fff");
        System.out.println(stringSinglyLinkedList.toString());
        stringSinglyLinkedList.remove("ccc");
        System.out.println(stringSinglyLinkedList.toString());
        stringSinglyLinkedList.addFirst("tttt");
        System.out.println(stringSinglyLinkedList.toString());
        System.out.println(stringSinglyLinkedList.contains("eee"));
        stringSinglyLinkedList.add("ccc");
        System.out.println(stringSinglyLinkedList.toString());
        System.out.println(stringSinglyLinkedList.size());
    }
}
