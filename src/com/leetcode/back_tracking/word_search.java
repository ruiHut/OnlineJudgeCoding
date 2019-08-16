package com.leetcode.back_tracking;

/**
 * q_79 word_search
 * 1. backTracking
 */

// 89%
class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) ||
                   search(board, word, i+1, j, index+1) ||
                   search(board, word, i, j-1, index+1) ||
                   search(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}


// my version
public class wordSearch {
    public static void main(String[] args) {
        Solutionasd s=  new Solutionasd();
        char[][] a = new char[][]{{'a','b','c'}};

        System.out.println(s.exist(a, "b"));
    }
}


class Solutionasd {
    private int rows, cowls;
    private char lastChar;
    private boolean[][] isVisited;
    private int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;

        isVisited = new boolean[rows][cowls];
        rows = board.length;
        cowls = board[0].length;
        lastChar = word.charAt(word.length() - 1);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cowls; j++)
                if(isContains(board, word, 0, 0, 0))
                    return true;

        return false;
    }

    private boolean isContains(char[][] board, String word, int index, int x, int y) {
        if (index == word.length() -1 ) //  && board[x][y] == lastChar when recursion coming here is mean prev index equals
            return board[x][y] == word.charAt(index);

        if (board[x][y] == word.charAt(index)) {
            isVisited[x][y] = true;
            for (int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];
                if (!isValid(newx, newy)&& !isVisited[newx][newy] &&
                            isContains(board, word, index + 1,newx, newy))
                    return true;
            }
            isVisited[x][y] = false;
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cowls;
    }
}