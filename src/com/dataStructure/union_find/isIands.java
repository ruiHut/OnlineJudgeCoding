import java.util.*;

import jdk.internal.jshell.tool.resources.l10n;

/**
 * 200 isLands 
 * solution 
 * 1. flood fill 染色问题 （BFS or DFS)
 * 
 * 2. 并查集 
 *      1. 初始化并查集： 针对 ‘1’ 节点
 *      2. 遍历所有节点： ‘1’相邻节点合并  ‘0’ 不管 （统计）
 */
// flood fill
public class Solution {

    private int n;
    private int m;
    
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;

        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }    
        return count;
    }
    
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

}


// union find
class Solution {

    static int[][] distance = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int rows;
    static int colums;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || (grid[0].length == 0 && grid.length == 1)) return 0;

        UnionFind uf = new UnionFind(grid);
        rows = grid.length;
        colums = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (grid[i][j] == '1') {    //  遍历该节点周围节点
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1]; 
                        if (x >= 0 && x < rows && y >= 0 && y < colums && grid[x][y] == '1' ) { // vilid
                            int id1 = i * colums + j;
                            int id2 = x * colums + j;
                            uf.union(id1, id2);
                        }
                    }
                }   
            }
        }
        return uf.count;
    }
}


class UnionFind {
    static int rows;
    static int colums;
    
    int[] parent;
    int count = 0;
    UnionFind(char[][] grid) {
        rows = grid.length;
        colums = grid[0].length;
        parent = new int[rows * colums];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                // init uf
                if (grid[i][j] == '1') {
                    int id = i * colums + j;
                    parent[id] = id;
                    count++;
                }
            }
        }
    }

    // 将两个节点设置为同一父亲节点
    public void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        if (parent1 != parent2) {
            parent[parent1] = parent[parent2];
            count--;
        }
    }

    // find 找到该节点的父亲节点
    public int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = find(parent[node]);
        return parent[node];
    }
} 



class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length==0 || grid[0].length==0) return 0;
        int m=grid.length, n=grid[0].length, res=0;
        int[] d= new int[]{0,-1,0};
        int[] f= new int[m*n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]=='1'){
                    res++;
                    f[i*n+j]=i*n+j; // union init
                    for (int k=0; k<2; k++){
                        int I=i+d[k], J=j+d[k+1];
                        if (I<0 || I>=m || J<0 || J>=n || grid[I][J]!='1') continue;
                        int a= find(f, i*n+j), b= find(f, I*n+J);
                        if (a!=b){
                            f[b]=a; // union double node
                            res--;
                        }
                    }
                }
            }
        }
        
        return res;
    }
    public int find(int[] f, int id){
        while (id!=f[id]){
            f[id]=f[f[id]];
            id=f[id];
        }
        return id;
    }
}