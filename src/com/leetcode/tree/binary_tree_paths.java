package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
*   q_110 solution
*
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        // ending time
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        for (String  s: binaryTreePaths(root.left))
            res.add(String.valueOf(root.val) + "->" + s);

        for (String  s: binaryTreePaths(root.right))
            res.add(String.valueOf(root.val) + "->" + s);

        return  res;
    }
}