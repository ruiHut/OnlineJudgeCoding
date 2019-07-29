/**
 * 位运算
 * 1. 枚举所有位数， x % 2 == 0 ?  x = x >> 1
 * 2. 取最后一位非 0 数  x & (x - 1)
 */


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            if (n % 2 == 0) {
                n = n >> 1; 
            } else {
                count++;
                n = n >> 1;
            }
        }
        return count;
    }
} 


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       int count = 0;
       while (n != 0) {
            count ++;
            n = n & (n - 1);
       }
       return count;
    }
} 

