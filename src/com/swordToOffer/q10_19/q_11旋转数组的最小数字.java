package com.swordToOffer.q10_19;

/**
 * @program: OnlineJudgeCoding
 * @description:
 * @author: Mr.Zhou
 * @create: 2019-08-24 10:01
 **/

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2010~19.md#11-%E6%97%8B%E8%BD%AC%E6%95%B0%E7%BB%84%E7%9A%84%E6%9C%80%E5%B0%8F%E6%95%B0%E5%AD%97
public class q_11旋转数组的最小数字 {

    public int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[l] == nums[m] && nums[m] == nums[h])
                return minNumber(nums, l, h);
            else if (nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }

    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++)
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        return nums[l];
    }
}
