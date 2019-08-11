package com.leetcode.tree;

/**
 *  q_450 solution
 */
class Solution {
    // 删除指定 key 的节点，返回根节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        int curVal = root.val;
        if (curVal == key) {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            TreeNode minNode = minNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        } else if (curVal > key){
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode minNode(TreeNode root) {
        if (root == null) return null;

        while (root.left != null) root = root.left;
        return root;
    }
}