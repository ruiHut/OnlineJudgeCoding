package dataStructure.线段树;

/**
 * @program: LeedCode3
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-17 09:53
 **/

/**
 * 线段树不是完全二叉树
 */
public class 线段树的基本表示 {
    public static void main(String[] args) {

    }
}

class SegmentTree<E> {
    private E[] tree;
    private E[] data;

    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        // 为树开辟空间 4n
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0 , 0 ,data.length - 1 );
    }

    /**
     * 在treeIndex 的位置创建表示区间【 l ... r】的线段树
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r){
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2; // 当数据很大时 l + r 会溢出 解决方案  l+ (r - l) / 2

        buildSegmentTree(leftTreeIndex , l  , mid);
        buildSegmentTree(rightTreeIndex , mid + 1 , r);

        /**
         * 业务代码
         */
//        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];

    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal");
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中 ， 一个索引所表示的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中 ， 一个索引所表示的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }
}