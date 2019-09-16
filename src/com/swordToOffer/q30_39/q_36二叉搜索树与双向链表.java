package com.swordToOffer.q30_39;

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2030~39.md#36-%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%8E%E5%8F%8C%E5%90%91%E9%93%BE%E8%A1%A8
public class q_36二叉搜索树与双向链表 {
    private TreeNode pre = null;
    private TreeNode head = null;

    // 1<-2->3   -->  1<->2<->3;
    public TreeNode Convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    // 中序遍历
    private void inOrder(TreeNode node) {
        if (node == null)
            return;

        inOrder(node.left);
        node.left = pre;

        if (pre != null)
            pre.right = node;

        pre = node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }
}
