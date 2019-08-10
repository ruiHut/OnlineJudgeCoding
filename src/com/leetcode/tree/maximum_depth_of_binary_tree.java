package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 104 solution
 * 1. bfs
 * 2. dfs
 */
class Solution {
    // BFS
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            while (qSize-- != 0) {
                TreeNode curNode = q.poll();
                if (curNode != null && curNode.left != null) q.offer(curNode.left);
                if (curNode != null && curNode.right != null) q.offer(curNode.right);
            }
            res++;
        }
        return res;
    }

    // DFS
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }
}

class TreeNode {
    private int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}