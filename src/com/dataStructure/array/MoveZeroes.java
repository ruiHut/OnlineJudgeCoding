/**
 * 283 move zeroes
 * condition
 *  1. in-place
 *  2. minimize the total number of operations
 * 
 */

class Solution {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) return;

        int len = nums.length;
        int zeroNums = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroNums++;
            } else{
                if (zeroNums != 0) {
                     nums[i - zeroNums] = nums[i];
                }
            }
        }

        for (int i = len - zeroNums; i <len; i++)
            nums[i] = 0;

        return;
    }
}