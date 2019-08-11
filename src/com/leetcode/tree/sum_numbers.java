package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * q_129 solution
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        return helper(root.left, num * 10 + root.val) + helper(root.right, num * 10 + root.val);
    }
}

// Integer -> String -> Integer
class Solution {
    private List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        // ending time
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        for (String  s: binaryTreePaths(root.left))
            res.add(String.valueOf(root.val) + s);

        for (String  s: binaryTreePaths(root.right))
            res.add(String.valueOf(root.val) + s);

        return  res;
    }
    public int sumNumbers(TreeNode root) {
        int res = 0;
        List<String> paths = binaryTreePaths(root);
        for (String s : paths)
            res += Integer.valueOf(s);

        return res;
    }
}
