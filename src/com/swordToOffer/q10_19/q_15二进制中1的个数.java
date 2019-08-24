package com.swordToOffer.q10_19;

/**
 * @program: OnlineJudgeCoding
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-08-24 22:22
 **/

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#15-%E4%BA%8C%E8%BF%9B%E5%88%B6%E4%B8%AD-1-%E7%9A%84%E4%B8%AA%E6%95%B0
public class q_15二进制中1的个数 {
    // n&(n-1)
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

    // jdk
    public int NumberOf12(int n) {
        return Integer.bitCount(n);
    }
}
