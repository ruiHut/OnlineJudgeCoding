import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.classfile.Node;
import com.sun.tools.javac.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 145 solution
 * 1. recusion
 * 2. use stack
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res; // return null is unexpect

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
}

// use stack
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode lastVisted = null;
        TreeNode node = root;
        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                curNode = s.peek();
                // if right child exists and traversing node
                // from left child, then move right
                if (curNode.right != null && curNode.right != lastVisted) {
                    node = curNode.right;
                } else {
                    res.add(curNode.val);
                    lastVisted = s.pop();
                }
            }
        }
        return res;
    }
}