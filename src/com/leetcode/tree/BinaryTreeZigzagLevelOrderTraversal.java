import java.util.Deque;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 *  123 solution 
 *   1. BFS Deque use a flag offerFirst and pollLast
 *   2. DFS ?
 * }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return res;

        TreeNode node = root;
        Deque<TreeNode>  q = new LinkedList<>();
        q.offerFirst(node);
        // flag true mean left to right else callback
        boolean flag = true;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (flag) {
                    TreeNode curNode = q.pollFirst();
                    levelNodes.add(curNode.val);
                    if (curNode.left != null) q.offerLast(curNode.left);
                    if (curNode.right != null) q.offerLast(curNode.right);
                } else {
                    TreeNode curNode = q.pollLast();
                    levelNodes.add(curNode.val);
                    if (curNode.right != null) q.offerFirst(curNode.right);
                    if (curNode.left != null) q.offerFirst(curNode.left);
                }
            }
            res.add(levelNodes);
            flag = !flag;
        }
        return res;
    }
}

// DFS
class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return ret;
        sol(root, 0, 0);
        sol(root, 0, 1);
        return ret;
    }
    
    void sol(TreeNode cur, int level, int dir) {
        if(cur == null) return;
        if(level >= ret.size()) ret.add(new ArrayList<>());
        if(level % 2 == dir) ret.get(level).add(cur.val);
        if(dir == 0) {
            sol(cur.left, level+1, dir);
            sol(cur.right, level+1, dir);
        } else {
            sol(cur.right, level+1, dir);
            sol(cur.left, level+1, dir);
        }
    }
}