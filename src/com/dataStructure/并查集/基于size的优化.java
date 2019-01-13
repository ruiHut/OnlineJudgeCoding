package dataStructure.并查集;

/**
 * @program: LeedCode3
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-13 21:00
 **/

public class 基于size的优化 {
    public static void main(String[] args) {

    }
}

class QuickUnion2 implements UF {
    private int[] parent;
    private int[] size;

    public QuickUnion2(int parent, int size){
        this.parent = new int[parent];
        this.size = new int[size];

        for (int i : this.parent)
            this.parent[i] = i;
        for (int i: this.size)
            this.size[i] = 1;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查看元素p和元素q是否在一个集合内
     * 时间复杂度 o（H） h为树的高度
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return Parent1(p) == Parent1(q);
    }

    /**
     * 查找该节点的根节点 递归实现
     * @param elements
     * @return
     */
    private int Parent1(int elements){
        if (elements<0 && elements>= parent.length)
            throw new IllegalArgumentException("elements is out of bound.");
        if (parent[elements] == elements)
            return elements;
        return Parent1(parent[elements]);
    }

    /**
     * 查找该节点的根节点 普通实现
     * @param elements
     * @return
     */
    private int Parent2(int elements){
        if (elements<0 && elements>= parent.length)
            throw new IllegalArgumentException("elements is out of bound.");

        while (elements != parent[elements])
            elements = parent[elements];
        return elements;
    }

    /**
     * 合并元素p 和元素q
     * 时间复杂度 o（H） h为树的高度
     * 将元素个数少的集合合并到元素个数的集合上
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {

        int pRoot = Parent1(p);
        int qRoot = Parent1(q);
        if(pRoot == qRoot)
            return;

        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        else{
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}