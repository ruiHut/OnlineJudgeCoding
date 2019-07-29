package com.leedcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @program: LeedCode
 * @description: 349
 * @author: Mr.Zhou
 * @create: 2018-12-01 17:49
 **/

public class _349_求两个矩阵的交集 {
    public static void main(String[] args) {
        int[] nums1 = {1 , 2 , 2 , 1};
        int[] nums2 = {2 , 2};
//        Solutions solution = new Solution();
//        int[] nums3 = solution.intersection(nums1 , nums2);
//        System.out.println(Arrays.asList(nums3).size());
    }
}

class Solutions {
    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i :
             nums1) {
          treeSet.add(i);
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int n :
             nums2) {
            if (treeSet.contains(n)){
                res.add(n);
                treeSet.remove(n);
            }
        }
        int[] res_ =  new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            res_[i] = res.get(i);
        }
        return res_;
    }
}