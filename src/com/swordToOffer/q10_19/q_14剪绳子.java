package com.swordToOffer.q10_19;

import javax.swing.*;

/**
 * @program: OnlineJudgeCoding
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-08-24 21:21
 **/

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#14-%E5%89%AA%E7%BB%B3%E5%AD%90
public class q_14剪绳子 {

    // 贪心
    public int integerBreak(int n) {
        if (n < 2) return 0;

        if (n == 2) return 1;

        if (n == 3) return 2;

        return n % 3 == 1 ? (int) Math.pow(3, (n / 3 - 1)) * 4 :
                       n % 3 == 0 ? (int) Math.pow(3, (n / 3)) : (int) Math.pow(3, (n / 3)) * 2;

    }

    // DP
    public int integerBreakDB(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));

        return dp[n];
    }
}
