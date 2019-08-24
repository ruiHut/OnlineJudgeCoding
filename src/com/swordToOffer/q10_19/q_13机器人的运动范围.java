package com.swordToOffer.q10_19;

/**
 * @program: OnlineJudgeCoding
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-08-24 11:57
 **/

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#13-%E6%9C%BA%E5%99%A8%E4%BA%BA%E7%9A%84%E8%BF%90%E5%8A%A8%E8%8C%83%E5%9B%B4
public class q_13机器人的运动范围 {

    private static final int[][] next ={{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private int cnt = 0;
    int rows, cols, threshold;
    private int[][] digitSum;

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return cnt;
    }

    private void dfs(boolean[][] marked, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c])
            return;

        marked[r][c] = true;
        if (this.digitSum[r][c] > this.threshold)
            return;
        for (int[] n : next)
            dfs(marked, r + n[0], c + n[1]);

    }

    private void initDigitSum() {
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            while (n > 0) {
                digitSumOne[i]  += n % 10;
                n /= 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.cols; j++)
                this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
    }

}
