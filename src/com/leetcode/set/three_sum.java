import java.util.ArrayList;
import java.util.HashMap;

import com.sun.tools.javac.util.List;

/**
 * 1. 暴力 三层循环
 * 2. 两层循环 + set
 * 3. 先排序，一层循环 +  两端向中间推进
 */


// 两层循环 + set
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return null;

        int len = nums.length;
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        HashMap<Integer, Integer> numSet = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                int twoSum = nums[i] + nums[j];
                if (numSet.containsKey(-twoSum)){
                    threeSum.clear();
                    threeSum.addAll(new int[]{-twoSum, num[i], num[j]});
                    ret.add(threeSum);
                } else {
                    threeSum.put
                }

            }
        }
    }
}