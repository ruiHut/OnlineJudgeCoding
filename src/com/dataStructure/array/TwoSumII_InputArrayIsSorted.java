/**
 * 1. 167 solution
 * 1. fuck it 
 * 2. sliding window
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while( left < right) {
            if (numbers[left] + numbers[right] == target)
                return new int[]{left + 1, right - 1};
            else if (numbers[left] + numbers[right] > target)
                right--;
            else 
                left++;
        }
        return new int[]{-1, -1};
    }
}