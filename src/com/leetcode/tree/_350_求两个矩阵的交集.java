package com.leedcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @program: LeedCode
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-01 18:48
 **/

public class _350_求两个矩阵的交集 {

}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        /**
         * 将 nums1 存入 treeMap中
         * key : 数值
         * value : 出现的次数
         */
        for (int n : nums1) {
            if (!treeMap.containsKey(n)) {
                treeMap.put(n, 0);
            } else {
                int res = treeMap.get(n);
                treeMap.put(n, res + 1);
            }
        }
        /**
         * 遍历 nums2 如果无重复元素直接pass 如果以存在 list 新增一条记录且其 values -1 如果
         */
        List<Integer> list = new ArrayList();
        for (int n : nums2) {
            if (!treeMap.containsKey(n)) { //如果不存在key值
                continue;
            } else {
                if (treeMap.get(n) >= 0) { // 如果key值>0
                    list.add(n);
                    treeMap.put(n, treeMap.get(n) - 1);
                }else {
                    treeMap.remove(n);
                }
            }
        }
        int[] res_ =  new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res_[i] = list.get(i);
        }
        return res_;
    }

    
}