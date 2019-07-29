import java.util.Arrays;

/**
 *  215 Kth largest element in an array ：未排序数组的第 k 个最大元素
 *  1. 堆排序， 最大堆
 *  2. 快排  由于其对与数组无需排序，即仅查找即可 （二分查找 + 快排结合
 *  3. 优先队列  二叉堆
 *  4. 直接排序，返回结果
 */

// 直接排序
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // ending time: 待分割数组长度小于一。
        if (nums == null || nums.length <= 1) return nums.length;

        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

// 优先队列 （二叉堆） 优先队列是否会保存重复元素 ？
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) 
            pq.offer(nums[i]);

        if(pq.size() > k)
            pq.poll();

        return pq.peek();
    }
}

// quickSort and BinarySort
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
    }
}
