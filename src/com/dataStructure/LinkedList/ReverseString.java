/**
 *  344 solution
 * 1. 是否可以使用额外空间 ， StringBuffer || StringBuilder func  reverse()
 * 2. 位运算
 */

 // use bit to swap
class Solution {
    public void reverseString(char[] s) {
        if (s.length <= 1) return;

        int left = 0, right = s.length - 1;
        while(left < right){
            if (s[left] != s[right]) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            } else {
                left++;
                right--;
            }
        }
        return;
    }
}