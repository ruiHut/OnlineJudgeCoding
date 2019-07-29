import java.awt.List;
import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 94 binary tree inorder
 * 1. resusion
 * 2. iterative
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // list is abstract; cannot be instantiated return new List<Integer>();
        if (root == null) return new ArrayList<Integer>(); 

        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<Integer>();
        TreeNode node =  root;
        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                TreeNode curNode = s.pop();
                res.add(curNode.val);
                node = curNode.right;
            }
        }
        return res;
    }
}