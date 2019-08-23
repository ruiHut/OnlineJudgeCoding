package com.swordToOffer.q3_10;

/**
 * @program: OnlineJudgeCoding
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-08-23 14:08
 **/

/**
 * solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%203~9.md#8-%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E4%B8%8B%E4%B8%80%E4%B8%AA%E7%BB%93%E7%82%B9
 */
public class q_8二叉树的下一个节点 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;

        // 右节点不为空，那么该节点的下一个节点是右子树的最左节点
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null)
                right = right.left;

            return right;
        } else { // 否则，向上找第一个左链接指向的树包含该节点的祖先节点。
            while (pNode.next != null && pNode.next.right == pNode)
                pNode = pNode.next;
            
            return pNode;
        }
    }

}

class TreeLinkNode {

    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}