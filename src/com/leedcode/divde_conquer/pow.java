/**
 * solution:
 *  1. use system func o(1)
 *  2. fuck count      o(N)
 *  3. divde_conquer   o(logn)
 */

class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }
}

class Solution {
    public double myPow(double x, int n) {
        int poxSum = 1;
        for (int i = 0; i < n; i++) {
            poxSum = poxSum * x;
        }
        return poxSum;
    }
}

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        
        // n 为负数时，转换为求其倒数。
        if (n  < 0) {
            n = -n;     // n == Integer.MIN_VALUE 溢出情况发生。
            x = 1 / x;
        }
        
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}