import com.sun.swing.internal.plaf.metal.resources.metal;

/**
 *  二分查找 N(logN)
 * 使用条件：
 * 1. 查找元素单调递增 *
 * 2. 存在明显上下界
 * 3. 能够通过索引访问，例如数组
 */

 // 伪代码 pythen
// left, right = 0, len(array) -1
// while left <= right:
//     if array[mid] == target:
//     // find the target!!
//     break or return result 
//     else if array[mid] < target:
//         left = mid +1
//     else: 
//         right = mid - 1

// leedcode 69 sqet(y)

class solution {
    public int sqrt(int x) {
        if (x == o || x == 1) return x;

        int l = 1, r = x, res;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
                res = m;
            }
        }
        return res;
    }
}

class Solution {
    public int mySqrt(int x) {
        if (x < 0) 
            throw new IllegalArgumentException("sqrt input number less then zore");

        if (x == 0 || x == 1) return x;

        int left = 0, right = x;
        int res = 0;
        while (left <= right) {
            int mid = ((right - left) / 2) + left;
            if (mid == x / mid){
                return mid; // more better than x == mid * mid 
            }    
            else if (mid > x / mid){
                 right = mid - 1;
            }
            else {
                left = mid + 1;
                res = mid;  // when  left  <  result  < mid  and  ( mid - left) < 1
            }
        }
        return res;
    }
}