import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

// flood fll BFS 
// BFS 对于存储 Queue 不优雅
class Solution {
    char[][] charQueue;
    Set<E> visited = new HashSet<>();
    public int numIslands(char[][] grid) {
        int rows = grid.length; // 行数
        int colums = grid[0].length; // 列数
        charQueue = new char[2][colums];  // 第一行存放该节点行数，第二行存放该节点列数。
        // 一维数组判断空 1. arr == null || arr.length == 0
        // 二维数组判断空 arr == null || arr.length == 0 || (arr.length == 1 && arr[1].length == 0)
        if (grid == null || rows == 0 || (rows == 1 && colums == 0)) return 0;


        for(int i = 0; i < charQueue.length; i++){//控制每个一维数组 
			for(int n = 0; n < charQueue[i].length; n++){//控制每个一维数组中的元素
                if (i == 0) charQueue[i][n] = i;
                else charQueue[i][n] = n;
            }
		}
       
        while(q.size() != 0) {
            if (c == '1') {

            }
        }
    }
}

// flood fill use DFS
class Solution {
    // Set visited; 对于此题二维数组遍历不存在是否被访问问题，无需 visited set
    int rows;
    int colums;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        colums = grid[0].length;
        if (grid == null || rows == 0 || (rows == 1 && colums == 0)) return 0;

        Set visited = new HashSet();
        floodFillWithDFS(grid, 0, 0, visited);
        return landsNum(grid);
    }

    private void floodFillWithDFS(char[][] grid, int i, int n, Set visited) {
        // ending time
        if (i == rows - 1 && n == colums - 1) return;

        // visited.add(i, n)
        char cur = grid[i][n];
        if (cur == "1") {
            floodFillAround(grid, i, n);
        }
        row = nextRow(i);
        colum = nextColum(n);
        floodFillWithDFS(grid, row, colum, visited);
        // process cur node
    }

    private int landsNum(char[][] grid) {
        int nums = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                char c = grid[i][j];
                if (c == '1') nums += 1;
            }
        }       
        return nums;
    }

    private void floodFillAround(char[][] grid, int row, int colum) {
        
    }
}

// DFS
class Solution {
    static int[] dx;
    static int[] dy;
    
    private int rows;
    private int colums;
    private int[][] grid;
    
    private Set visited;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || (grid.length == 1 && grid[0].length == 0)) return 0;
        
        initIslands(grid);

        int sum = 0;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < colums; j++) {
               sum = sum + floodFillDFS(i, j);
            }
        }
        return sum;
    }

    private int  floodFillDFS(int x, int y) {
        if (!isValid(x, y)) return 0;

        // visited.add((x, y));
        for (int i = 0; i < 4; i++) 
            floodFillDFS(x + dx[i], y + dy[i]);

        return 1;
    }

    // BFS
    private int floodFillBFS(int x, int y) {
        if (!isValid(x, y)) return 0;

        // visited.add((x, y));

    }

    /**
     * 1. 越界
     * 2. 为 0
     * 3. 被访问过
     */
    private boolean isValid(int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= colums) return false;

        if (grid[x][y] == '0') return false;

        // 如何确定是否被访问

        return true;
    }

    private void initIslands(char[][] grid) {
        rows = grid.length;
        colums = grid[0].length;
        grid =  grid;
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};
        visited = new HashMap();
    }
}

public class Solution {

    private int n;
    private int m;
    
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        
        dx = new int[]{0, 0, -1 ,1};
        dy = new int[]{-1, 1, 0, 0};

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
class solution {

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