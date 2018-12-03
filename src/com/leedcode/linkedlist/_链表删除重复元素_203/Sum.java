package com.leedcode.linkedlist._链表删除重复元素_203;

/**
 * @program: LeedCode
 * @description: 递归遍历数组
 * @author: Mr.Zhou
 * @create: 2018-11-23 23:19
 **/

public class Sum {
    /**
     * 递归遍历数组求和
     * @param arr
     * @return
     */
    public static int sum(int[] arr){
        return sum(arr , 0);
    }


    /**
     * 计算arr[l...n]这个区间内的所有数组之和
     * @param arr : 带遍历数组
     * @param l ： 遍历起点此例中我们默认从0开始
     * @return
     */
    private static int sum(int[] arr , int l){
        if (l == arr.length)
            return 0;
        return 1 + sum(arr , l+1);
    }
    private static int sum2(int[] arr , int l){
        if (l == arr.length)
            return 0;
        int x = sum(arr , l+1);
        int res = arr[l]+ x;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1 ,2 ,3 ,4,5 };
        int n = sum(nums);
        System.out.println(n);

    }
}
