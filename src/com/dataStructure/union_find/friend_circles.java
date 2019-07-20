/**
 * 547 朋友圈
 * solution
 * 1. 染色 （BFS DFS）
 * 2. 并查集
 */

// FloodFill DFS
class Solution {
    static int rows, colums;
    static int[][] checker;
    static int[][] distance = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int findCircleNum(int[][] M) {
        if (M.length==0 || M[0].length==0) return 0;
        
        checker = M;
        rows = checker.length;
        colums = checker[0].length;
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (checker[i][j] == 1) {
                  sum++;
                  floodFillDFS(i, j);
                }
            }
        }
        return sum;
    }
    
    private void floodFillDFS(int x, int y) {
        if (!valid(x, y)) return;

        checker[x][y] = 0;
        for (int[] d : distance) 
            floodFillDFS(x + d[0], y + d[1]);
        
        return;
    }
    private boolean valid(int x, int y) {
        return x < 0 || x >= rows || y < 0 || y >= colums ||  checker[x][y] != 1 ? false : true;
    }
}

// use Union_Find
class Solution {
    int[][] distance = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int[][] checker;
    int rows, colums;
    int[] father;
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
    
        checker = M;
        rows = checker.length;
        colums = checker[0].length;
        father = new int[rows * colums];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (checker[i][j] == 1) {
                    count++;
                    // init uf
                    int cur = i * colums + j;
                    father[cur] = cur;
                    // floodFill 
                    for (int[] d : distance) {
                        // isValid node
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x < 0 || x >= rows || y < 0 || y >= colums || checker[x][y] != 1) continue;

                        if (find(cur) == find(x * colums + y)){
                            continue;
                        } else {
                            count--;
                            father[find(x * colums + y)] =  find(cur);
                        }
                    }
                }
            }
        }
        return count;
    }

    private int find(int node) {
        if (father[node] == node) return node;

        return find(father[node]);
    }
}