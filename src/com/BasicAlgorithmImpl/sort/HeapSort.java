package com.BasicAlgorithmImpl.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * HeapSort 堆排序
 * 1. PriorityQueue
 */


// 1， PriorityQueue
class HeapSort {
    // 从小到大
    public static void HeapSort(int[] arr) {
        if (arr.length <= 1) return;

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i: arr)
            pq.offer(i);

        for (int i = 0; i < arr.length; i++)
            arr[i] = pq.remove();
    }

    // 从小到大
    public static void HeapSortdesc(int[] arr) {
        if (arr.length <= 1) return;

        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i: arr)
            pq.offer(i);

        for (int i = 0; i < arr.length; i++)
            arr[i] = pq.remove();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3,1, -1};
        HeapSort.HeapSort(arr);
        // [-1, 1, 1, 2, 3]
        System.out.println(Arrays.toString(arr));
        HeapSort.HeapSortdesc(arr);
        // [3, 2, 1, 1, -1]
        System.out.println(Arrays.toString(arr));
    }
}