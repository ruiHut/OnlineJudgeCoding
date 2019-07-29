import java.util.ArrayList;
import java.util.Arrays;

/**
 * q 12 3sum
 * solution
 *  1.(for3) O(n3)
 *  2. sort first and then find the result O(n2)
 */

 // copy from leedcode discuss
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i]>0) break;
            if(i==0||(i>0)&&(nums[i]!=nums[i-1])){ // x unable have same one
                int lo=i+1,hi=nums.length-1, sum=0-nums[i];
                while(lo<hi){
                    if(nums[lo]+nums[hi]==sum){ // y, z 从两端缩进
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while(lo<hi&&nums[lo]==nums[lo+1]) lo++;
                        while(lo<hi&&nums[hi]==nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    }
                    else if(nums[lo]+nums[hi]<sum) lo++;
                    else hi--;
                }                    
            }
        }
    }
}


// format and add a trick
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return res;

        int len = nums.length;
        Arrays.sort(nums); // sort O(nlogn)
        for (int i = 0; i < len - 2; i++) { // O(n2)
            if (nums[i] > 0) break;
            if ((i == 0) || nums[i] != nums[i - 1] ) {
                int sum = 0 - nums[i];
                int left = i + 1, right = len - 1;
                while (left < right) {
                    if ((nums[i] + nums[left]) > 0) break;

                    if (sum == nums[left] + nums[right]) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if(nums[left] + nums[right] < sum) {
                        left++;
                    }  else { 
                        right--;
                    }
                }
            }
        }
        return res;
    }
}