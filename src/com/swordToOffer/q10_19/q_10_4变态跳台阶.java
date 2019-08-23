package com.swordToOffer.q10_19;

import java.util.Arrays;

/**
 * @program: OnlineJudgeCoding
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-08-23 23:42
 **/

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#104-%E5%8F%98%E6%80%81%E8%B7%B3%E5%8F%B0%E9%98%B6
public class q_10_4变态跳台阶 {

    // 动态规划
    public int JumpFloorII(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];

        return dp[n - 1];
    }

    // 数学推导 f(n) - f(n-1) = f(n-1) -》 f(n) = 2*f(n-1)
    public int JumpFloorIIWithMath(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
