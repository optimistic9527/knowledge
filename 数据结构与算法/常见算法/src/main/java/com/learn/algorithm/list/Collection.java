package com.learn.algorithm.list;

/**
 * @author guoxingyong
 * @data 2019/3/26 15:53
 */
public interface Collection<E> {

    int size();

    boolean isEmpty();

    boolean contains(E e);

    boolean add(E e);

    boolean remove(E e);

    boolean addFirst(E e);

    E get(int index);
}
