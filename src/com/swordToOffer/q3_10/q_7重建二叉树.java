package com.swordToOffer.q3_10;

/**
 * @program: OnlineJudgeCoding
 * @description: 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @author: Mr.Zhou
 * @create: 2019-08-23 10:48
 **/

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%203~9.md#7-%E9%87%8D%E5%BB%BA%E4%BA%8C%E5%8F%89%E6%A0%91
 */
public class q_7重建二叉树 {

    private Map<Integer, Integer> indextForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indextForInOrders.put(in[i], i);
        }

        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indextForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;

    }

    class TreeNode {
        TreeNode left;
        TreeNode right;

        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
