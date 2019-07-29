/**
 * 16 3Sum Closest
 * 1. fuck it use (n3)
 * 2. sliing window and sort first (n2)
 *      1. sort first 
 *      2. 
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return -1;

        Arrays.sort(nums);
        int len = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2]; // can`t use Integer.MAX_VALUE
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            while(left < right) {
                int curSum = nums[left] + nums[right] + nums[i];
                if (Math.abs(curSum-target)<Math.abs(closestSum-target)) {
                    closestSum = curSum;
                }

                if(curSum > target)
                    right--;
                else if (curSum < target)
                    left++;
                else
                    return curSum;
            }
        }
        return closestSum;
    }
}