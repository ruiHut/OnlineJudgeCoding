### 动态规划 Dynanic Programming

1. 递归 + 记忆化 -> 递推
2. 状态的定义： opt[n], dp[n], fib[n]
3. 状态的转移方程： opt[n] = best_of(opt[n -1], opt[n - 2], ...)
4. 最优子结构


#### 斐波那契数列 动态规划实现
```

// 斐波那契数列
0， 1， 1， 2， 3， 5， ，8， 13， 21， ...
递推公式： F[n] = F[n - 1 + F[n - 2]

1. 递归版本 O(2n)
return n <= 1? n : fib(n -1) + fib(n -2);

2. 记忆化 cache 避免计算重复状态  o(n)

3.递归 + 记忆化 ==》 递推  顺序从下往上 + cache
int[] f = new int[n];
f[0] = 0, f[1] = 1;
for (int i = 2; i <= n; i++) {
    f[i] = f[i -1] + f[i - 2]
}
return f[n];
```

### DP vs 回溯 vs 贪心

* 回溯（递归）： 重复计算
* 贪心 - 永远局部最优
* DP - 记录局部最优子结构 / 多种记录值

