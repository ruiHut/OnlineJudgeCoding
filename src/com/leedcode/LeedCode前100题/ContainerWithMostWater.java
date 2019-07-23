/**
 * solution
 * 1. fuck it use double iteative O(n2)
 * 2. make to point left and right o(n)// if height[left] == height[right]
 */
class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;       

        int len = height.length;
        int max = 0;
        int left = 0, right = len - 1;
        while(left != right) {
            int curMax = (right - left) * Math.min(height(left), height[right]);
            max = Math.max(curMax, max);
            if (height[left] > height[right]) // when height[left] == height[right] does not matter with the result
                right--;
            else  
                left++;   
        }
        return max;
    }
}