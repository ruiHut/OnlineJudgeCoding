package dataStructure.并查集;

/**
 * @program: LeedCode3
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-01-13 20:01
 **/

public class 快速查找 {
    public static void main(String[] args) {

    }
}


class UnionFind1 implements UF{

    private int[] id;

    public UnionFind1(int size){
        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素p所对应的集合编号
     * @param p
     * @return
     */
    private int find(int p){
        if (p < 0 && p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");
        return id[p];
    }

    /**
     * 查看元素p和元素q是否属于同一个集合
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 将两个元素合并为一个组 时间复杂度 o（N）
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pUnion = find(p);
        int qUnion = find(q);
        if (pUnion == qUnion)
            return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == qUnion){
                id[i] = pUnion;
            }
        }
    }
}


class QuickUnion implements UF {
    private int[] parent;

    public QuickUnion(int size){
        parent = new int[size];

        for (int i : parent)
            parent[i] = i;
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
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {

        int pRoot = Parent1(p);
        int qRoot = Parent1(q);
        if(pRoot == qRoot)
            return;

        parent[pRoot] = qRoot;
    }
}