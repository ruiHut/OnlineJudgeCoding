package com.swordToOffer.q10_19;

/**
 * @program: OnlineJudgeCoding
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-08-23 22:54
 **/


// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#101-%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%97
public class q_10_1斐波那契数列 {

    // cache array way
    public int Fibonacci(int n) {
        if (n <= 1)
            return n;

        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    // cache fib(n -1) fib(n - 2)
    public int FibonacciDB(int n) {
        if (n <= 1)
            return n;

        int pre1 = 1, pre2 = 0;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }

        return res;
    }

    // prev cache all the result use array
    private static int[] fib = new int[40];

    static {
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
    }

    public int FibonacciDBCache(int n) {
        if (n > 40 || n < 0)
            return n;

        return fib[n];
    }
}
