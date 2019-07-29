package com.leedcode.LeedCode前100题;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeedCode2
 * @description:
 * @author: Mr.Zhou
 * @create: 2018-12-13 15:43
 **/

public class _1_两数求和 {
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, 9);
        System.out.println(result[0] + result[1]);
    }
}

/**
 * 1. 暴力解法 时间复杂度 n（n2）
 *              空间复杂度 n（1）
 */
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
                continue;
            }
        }
        return null;
    }
}
/**
 * 2 .使用散列表 hashcode 时间复杂度 n（n）
 *                         空间复杂度 n(n)
 */


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer ,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){  // 如果存在一个key 使得 target - key = num[i] 则说明这两个数为带求结果
                return new int[]{map.get(target - nums[i]) , i };
            }else {
                map.put(nums[i] , i);
            }
        }
        return null;
    }
}