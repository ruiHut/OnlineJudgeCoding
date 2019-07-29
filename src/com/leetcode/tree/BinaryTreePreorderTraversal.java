import java.util.ArrayList;

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
 * 144 solution
 * 1. recursion
 * 2. use stack
 */
class Solution {
    // recusion
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return null;
        
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
}

class Solution {
    // recusion
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList();

        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            result.add(node.val);
            
            // make sure node output first
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        } 
        
        return result;
    }
}