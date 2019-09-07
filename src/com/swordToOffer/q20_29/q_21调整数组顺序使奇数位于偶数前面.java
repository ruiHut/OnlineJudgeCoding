package com.swordToOffer.q20_29;

// solution: https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3%20-%2020~29.md#21-%E8%B0%83%E6%95%B4%E6%95%B0%E7%BB%84%E9%A1%BA%E5%BA%8F%E4%BD%BF%E5%A5%87%E6%95%B0%E4%BD%8D%E4%BA%8E%E5%81%B6%E6%95%B0%E5%89%8D%E9%9D%A2
// 1. 创建一个新数组，空间换时间
// 2. 冒泡思想- 每次都把当前偶数上浮到当前的最右边，时间换空间
public class q_21调整数组顺序使奇数位于偶数前面 {

    public void reOrderArray(int[] nums) {
        // 奇数个数
        int oddCnt = 0;
        for (int x : nums) {
            if (!isEven(x)) {
                oddCnt++;
            }
        }

        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int n : copy) {
            if (n % 2 == 1)
                nums[i++] = n; // 奇数从 0 -  ddCnt - 1
            else
                nums[j++] = n; // 偶数 oddCnt - nums.length - 1
        }
    }

    private boolean isEven(int x) {
        return x % 2 == 0;
    }

    public void reOrderArray2(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;

        int len = nums.length;
        for (int i = len - 1; i > len; i--) {
            for (int j = 0; j < i; j++) {
                if (isEven(nums[j]) && !isEven(nums[j + 1]))
                    swap(nums, j, j + 1);
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
