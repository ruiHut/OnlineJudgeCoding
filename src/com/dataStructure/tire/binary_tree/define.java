import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import sun.util.logging.PlatformLogger.Bridge;

/**
 * 二叉树集合
 * 定义： 一棵树只有两个节点。
 */

// 数据结构
class BinaryTree {
    BinaryTree left;
    BinaryTree right;
    int value;
    
    BinaryTree(int value) {
        this.value = value;
    }

    // preorder reursion
    public void preorder(BinaryTree node) {
        if (node == null) return;

        // 访问根节点
        visit(node);
        // 访问左孩子
        preorder(node.left); 
        // 访问右孩子
        preorder(node.right);
    }

    // preorder circulation
    iterativePreorder(BinaryTree node) {
        if (node == null) return;

        // use stack save
        Stack<BinaryTree> s = new Stack<BinaryTree>();
        s.push(node);

        while(!s.isEmpty()) {
            BinaryTree curNode = s.pop();
            visit(node);

            // right child is pushed first so that left is processed first
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        }
    }

    // inorder  recusion
    inOrder(BinaryTree node) {
        if (node == null) return;

        // 访问最左节点；
        inOrder(node.left);
        visit(node);
        inOrder(node.right);
    }

    iterativeInorder(BinaryTree node) {
        if (node == null) return;

        Stack<BinaryTree> s = new Stack<>();
        while(!s.isEmpty() && node != null) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                BinaryNode curNode = s.pop();
                visit(curNode);
                node = node.right;
            }
        }
    }

    // postOrder recusion
    postOrder(BinaryTree node) {
        if (node == null) return;

        BinaryTree(node.left);
        BinaryTree(node.right);
        visit(node);
    }

    // iterativePostorder
    iterativePostorder(BinaryTree node) {
        if (node == null) return;

        BinaryTree lastVisited = null;
        Stack<BinaryTree> s = new Stack<>();
        while (!s.empty() && node != null) {
            if (node == null) {
                s.push(node);
                node = node.left;
            } else {
                BinaryTree curNode = s.pop();
                if (curNode.right != null && curNode.right != lastVisited) {
                    s.push(curNode);
                } else { // 该节点右孩子遍历完毕，且不是第一次遍历，即需要 pop() 上升一层
                    visit(node);
                    lastVisited = s.pop();
                }
            }
        }
    }

    // level recusion BFS
    levelTrans(BinaryTree node) {
        if (node == null) return;

        Set<BinaryNode> visited = new HashSet<>();
        Queue<BinaryTree> q = new LinkedList<BinaryTree>();
        q.offer(node);
        while(!q.isEmpty()) {
            int size = q.size();
            // q.element(); 当队列为空时，会抛出空指针异常
            for (int i = 0; i < size; i++) {
                BinaryTree curNode = q.poll();
                visit(node);
                visited(curNode);
                //presess cur node
                BinaryTree[] childs[] = getChilds(curNode);
                for (BinaryTree n : childs) {
                    q.offer(n);
                }
            }
        }
    }
    // return father`s childs without visited node
    private BinaryTree[]  getChilds(BinaryTree father){
        if (father == null) return null;
    }   
}