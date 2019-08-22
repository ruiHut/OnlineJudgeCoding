package com.swordToOffer.q3_10;

/**
 * @program: OnlineJudgeCoding
 * @description: 数组中重复的数字：
 *  在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 *  数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 *  请找出数组中任意一个重复的数字。
 * @author: Mr.Zhou
 * @create: 2019-08-22 21:49
 **/

/**
 *  solution： https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%203~9.md#3-%E6%95%B0%E7%BB%84%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E6%95%B0%E5%AD%97
 */
public class q_3数组中重复的数字 {

    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || nums.length == 0)
            return false;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }

        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
