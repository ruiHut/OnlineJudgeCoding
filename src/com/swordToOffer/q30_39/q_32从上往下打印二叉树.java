package com.swordToOffer.q30_39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// solution：https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2030~39.md#321-%E4%BB%8E%E4%B8%8A%E5%BE%80%E4%B8%8B%E6%89%93%E5%8D%B0%E4%BA%8C%E5%8F%89%E6%A0%91
// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
//
// 例如，以下二叉树层次遍历的结果为：1,2,3,4,5,6,7
public class q_32从上往下打印二叉树 {

    // 层序遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                res.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }

        return res;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
}