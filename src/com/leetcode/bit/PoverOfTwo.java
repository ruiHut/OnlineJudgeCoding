/**
 * 231 power of two
 * 1. mod 2 
 * 2. log2  -> int
 * 3. bit  x & (x -1)
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        if((n & (n - 1)) == 0) return true; // if x return true else return false is stupit code
        else return false;
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}