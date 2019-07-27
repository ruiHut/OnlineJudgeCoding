/**
 * binary search
 * 前提条件： 
 *  1. 有序数组
 *  2. 有明显上限和下限
 * 
 * 相关数据结构：
 * 二分搜索树： 根节点大于左节点，小于右节点
 * 
 */

class Solution {
    public static int binarySearch(int[] val, int target) {
        if (val == null || val.length == 0) return -1;

        int len = var.length;
        int left = 0, right = len - 1;
        while(left <= right) { // 边界条件 left = right 满足查找区域为一个点
            int mid = left + (right - left) / 2;
            if (target == val[mid]) return mid;
            else if(target > val[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] var = new int[]{1, 2, 3, 4, 5};
        int n = Solution.binarySearch(var, 3);
        System.out.println(n);
    }
}