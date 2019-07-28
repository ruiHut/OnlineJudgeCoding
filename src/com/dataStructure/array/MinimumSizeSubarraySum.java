/**
 * 209 min size subarrary sum
 * 1. fuck it N3
 * 2. sliding windows n
 */

 // 滑动数组
class Solution {
    public int minSubArrayLen(int s, int[] nums) {

        int left = 0;
        int windSum = 0;
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            windSum += nums[i];
            while(windSum >= s) {
                minSize = Math.min(minSize, i - left + 1); // array index begin zero
                windSum -= nums[left++];
            }
        }
        return minSize != Integer.MAX_VALUE ? minSize : 0;
    }
}