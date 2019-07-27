/**
 * 75 sort colors
 * 1. bucket sort
 * 2. count sort 
 * 3. 三路归并
 */

 // count sort when the nums length so big then this way 
class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;

        // x = 0 , y = 1, z = 2
        int x = 0, y = 0, z = 0; // int is not good way in realize
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0: x++; break;
                case 1: y++; break;
                case 2: z++; break;
                default: throw new IllegalArgumentException(i);
            }
        }
        for (int i = 0; i < x; i++)
            nums[i] = 0;

        for (int i = x; i < y; i++) 
            nums[i] = 1;

        for (int i = y; i < z; i++) 
            nums[i] = 2;

        return;
    }
}

class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;

        int len = nums.length;
        int zoreIndex = 0, twoIndex = len - 1;
        for (int i = 0; i <= twoIndex; i++) {
            if (nums[i] < 1) {
                swap(nums, i, zoreIndex);
                zoreIndex++;
            } else if (nums[i] > 1) {
                swap(nums, i, twoIndex);
                twoIndex--;
                i--;
            }
        }

        return;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}