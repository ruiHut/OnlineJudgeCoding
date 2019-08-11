package com.leetcode.tree;


class Solution {
    private int check(TreeNode root) {
        if (root == null) return 0;

        int lh = check(root.left);
        int rh =  check(root.right);
        // lh and rh equals -1 means this tree have a node not balanced
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }

    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }
}