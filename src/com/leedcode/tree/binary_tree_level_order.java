import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import com.sun.tools.javac.util.List;

/**
 * solution:
 * 1. BFS o(N)
 *      如何判断是那层？该节点是末尾节点
 *      1. 将 level {level int, isEndElement bool} 信息添加到 queue 中，会导致 queue 中对象结构复杂不推荐
 *      2. 每层中再次循环，一层一层循环， Batch process 代码 
 * 2. DFS o(N)
 *      先建立二维数组。每次递归 level + 1， 按照该 level 放入目标数组中
 *      
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        
        HashSet visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (!q.isEmpty()) {
            List<Integer> levelNode = new ArrayList<>();

            int levelNum = q.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = q.poll();
                levelNode.add(node.val);

                TreeNode[] nodes = generateRelatedNodeds(node, visited);
                offerToQueue(nodes, q);
            }
            result.add(levelNode);
        }
        return result;
    }

    private TreeNode[] generateRelatedNodeds(TreeNode node, HashSet visited) {
        if (visited.contains(node)) {return null;} 
        else {visited.add(node);}
        
        List<TreeNode> relatedNodes = new ArrayList<TreeNode>();
        if (node.left != null) relatedNodes.add(node.left);
        if (node.right != null) relatedNodes.add(node.right);

        return (TreeNode[])relatedNodes.toArray();
    }

    private void offerToQueue(TreeNode[] nodes, Queue q) {
        if (nodes != null){
            for (int i = 0; i < nodes.length; i++) {
                // queue add and remove 失败时会报异常，推荐 offer and poll
                q.offer(nodes[i]);
            }
        }
    }
}