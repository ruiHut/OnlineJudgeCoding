package com.swordToOffer.q20_29;

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2020~29.md#28-%E5%AF%B9%E7%A7%B0%E7%9A%84%E4%BA%8C%E5%8F%89%E6%A0%91
// desc: 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
public class q_28对称的二叉树 {

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;

        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null) // t1, t2 的前提都不为 null. 由此仅需要判断是否有一方为 null 则为 false
            return false;
        if (t1.var != t2.var)
            return false;

        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
    }
}

