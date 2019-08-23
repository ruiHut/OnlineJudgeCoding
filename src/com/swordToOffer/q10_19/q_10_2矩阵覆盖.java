package com.swordToOffer.q10_19;

/**
 * @program: OnlineJudgeCoding
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-08-23 23:27
 **/

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#102-%E7%9F%A9%E5%BD%A2%E8%A6%86%E7%9B%96
public class q_10_2矩阵覆盖 {
    public int RectCover(int n) {
        if (n <= 2)
            return n;

        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }

        return result;
    }
}
