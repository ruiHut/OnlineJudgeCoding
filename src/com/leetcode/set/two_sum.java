import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 1. double circulation
 * 2. use set
 */

 // 1. double circulation
class Solution {
    public int[] twoSum(int[] nums, int target) {

        if (nums.length < 1)
            return new int[]{};

        int len = nums.length;
        // x enums
        for (int i = 0; i < len -1; i++)
        {
            int x = nums[i];
            int y = target - x;
            for (int j = i + 1; j < len; j++)
            {
                if (x + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return null;
    }
}

// 2. set
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> numsMap = new HashMap(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numsMap.containsKey(complement)) {
                return new int[]{i, numsMap.get(complement)};
            }
            numsMap.put(nums[i], i);
        }

        return null;
    }
}