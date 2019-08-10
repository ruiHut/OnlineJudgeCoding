package com.leetcode.tree;

// solution  https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958/Concise-Java-solutions-O(log(n)2)
class Solution {

    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                       height(root.right) == h - 1 ? (1 << h) + countNodes(root.right)
                               : (1 << h - 1) + countNodes(root.left);
    }

    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
}