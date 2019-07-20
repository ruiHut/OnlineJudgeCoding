/**
 * 70 Climbing Stairs
 * 1. 回溯
 * 2. DP
 */

// 1. 回溯
class Solution {
    public int climbStairs(int n) {
        return n <= 1 ? n : climbStairs(n - 1) + climbStairs(n - 2);
    }
}

// 2. 回溯 + cache
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        return climbStair(n, 2, 1, 1);
    }

    private int  climbStair(int n, int cur, int difN1, int difN2) {
        if (cur == n) return difN1 + difN2; // ending time
        return climbStair(n, ++cur, difN1 + difN2, difN1);  // cache
    }
}

// 3. DP 从下往上递推，确定状态。
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return n;
        int difN1 = 1, difN2 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = difN1 + difN2;
            difN2 = difN1;
            difN1 = res;          
        }
        return res;
    }
}
// 3. DP + array cache most fast but use more menmory
class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1 || n==2) return n;
        int[] mem=new int[n];
        mem[0]=1;
        mem[1]=2;
        for(int i=2;i<n;i++){
            mem[i]=mem[i-1]+mem[i-2];
        }
        return mem[n-1];
    }
}