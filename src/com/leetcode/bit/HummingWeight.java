/**
 * 位运算
 * 1. 枚举所有位数， x % 2 == 0 ?  x = x >> 1
 * 2. 取最后一位非 0 数  x & (x - 1)
 * 3. 空间换时间
 *      * 查表法
 *      * 二次查表法
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

// 二次查表法
class Solution {
    public int hummingWeight(int n) {
        uint16 n1 = n & 0xFFFF;
        uint16 n2 = (n>>16) & 0xFFFF;
        return  result[n1]+result[n2];
    }
}