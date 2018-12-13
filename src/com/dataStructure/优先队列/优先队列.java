package com.dataStructure.优先队列;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * @program: LeedCode2
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-06 16:31
 **/

public class 优先队列 {
    public static void main(String[] args) {

    }
}

/**
 * 优先队列 java 实现
 * @param <E>
 */
class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> eMaxHeap;
    public PriorityQueue(){
        eMaxHeap = new MaxHeap<>();
    }

    @Override
    public int size() {
        return eMaxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return eMaxHeap.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}

