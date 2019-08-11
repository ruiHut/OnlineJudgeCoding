package com.leetcode.tree;

/**
 * q_437 solution
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        int res = helper(root, sum - root.val);
        res += helper(root.left, sum);
        res += helper(root.right, sum);

        return res;
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;

        int res = 0;
        if (root.val == sum) res++;

        res += helper(root.left, sum - root.val);
        res += helper(root.left, sum - root.val);
        return res;
    }
}