package com.swordToOffer.q10_19;

import sun.security.x509.GeneralSubtrees;

/**
 * @program: OnlineJudgeCoding
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-08-23 23:32
 **/

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#103-%E8%B7%B3%E5%8F%B0%E9%98%B6
public class q_10_3跳台阶 {
    public int JumpFloor(int n) {
        if (n <= 2)
            return n;

        int pre2 = 1, pre1 = 2;
        int res = 1;
        for (int i = 2; i < n; i++) {
            res = pre2 + pre1;
            pre2 = pre1;
            pre1 = res;
        }

        return res;
    }
}
