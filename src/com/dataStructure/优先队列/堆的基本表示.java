package com.dataStructure.优先队列;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: HUTRepository
 * @description: 优先队列之堆的基本表示
 * @author: Mr.Zhou
 * @create: 2018-12-02 18:00
 **/

public class 堆的基本表示 {

    public static void main(String[] args) {
        // 测试最大堆 一百万数据量
        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 0; i < n; i++) {
            if (arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        }
        System.out.println("没问题");

    }

}

/**
 * 二叉树实现最大堆
 *
 * @param <E>
 */
class MaxHeap<E extends Comparable<E>> {
    // 使用动态数组实现
    private ArrayList<E> data;

    // 初始化可设置数组大小
    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayList<>();
    }
    /**
     * 返回堆中的元素个数
     */
    public int size() {
        return data.size();
    }

    /**
     * 返回一个 布尔值，表示堆中是否为空
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中 ， 一个索引表示的元素的父亲节点的索引
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index - 0 ");
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中 ， 一个索引表示的元素的左孩子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中 ， 一个索引表示的元素的右孩子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    /**
     * 遍历堆并添加对应元素 数据的上浮
     *
     * @param i
     */

    private void siftUp(int i) {

        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {
            // 把当前i所在元素和父亲元素交换
            swap(i, parent(i));
            i = parent(i);
        }
    }

    /**
     * 交换两个数值
     *
     * @param i
     * @param n
     */
    private void swap(int i, int n) {
        if (i < 0 || i >= size() || n < 0 || n >= size())
            throw new IllegalArgumentException(" index is illegal");
        E e = data.get(i);
        data.add(i, data.get(n));
        data.add(n, e);
    }

    /**
     * 查看堆中最大元素
     */
    public E findMax() {
        if (data.size() == 0)
            throw new IllegalArgumentException("can not findmax when heap is empty");
        return data.get(0);
    }

    /**
     * 取出堆中最大元素 并删除
     */
    public E extractMax() {
        E ret = findMax();

        // 将最右叶子节点和根节点交换并删除该节点
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(0);

        return ret;
    }

    /**
     * 调整变动节点下浮到该节点该处在的位置 符合最大堆的定义条件
     * @param i 需要下浮的节点
     */
    private void siftDown(int i) {

        while (leftChild(i) < data.size()) {
            int j = leftChild(i);
            if (j + 1 < data.size() && data.get(j).compareTo(data.get(i)) > 0)
                j = rightChild(i);
            // data[j] 是该节点左右节点的最大值
            if (data.get(i).compareTo(data.get(j)) >= 0)
                break;
            swap(j ,i);
            i = j;
        }
    }

}