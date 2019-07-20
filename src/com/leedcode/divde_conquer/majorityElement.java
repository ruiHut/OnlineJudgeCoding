/**
 * solution:
 * 1. fuck it use double circulation (n2)
 * 2. use map                        (n)
 * 3. sort and check the median num  (nlogn)  
 * 4. divde it and check the bigest one bewttem left and right (nlogn)
 * 5. vote                           (n)
 */

class Solution {
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityEleme***ec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityEleme***ec(nums, lo, mid);
        int right = majorityEleme***ec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityEleme***ec(nums, 0, nums.length-1);
    }
}