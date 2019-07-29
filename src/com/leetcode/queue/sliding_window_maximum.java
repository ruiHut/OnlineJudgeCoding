import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.graalvm.compiler.core.phases.MidTier;

/**
 *  滑动窗口
 *  1. 最大堆 nlog
 *  2. 双端队列 n
 * 
 * 题目特点 只需要得到最大值，切窗口大小不变 
 *  只需维护最大值在队列最左边即可。所以双端队列优于，最大堆
 */
class Solution {
    // PriorityQueue 实现最大堆
    private PriorityQueue<Integer> maxHeap;

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int len = nums.length;
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(i2, i1);
            }
        });

        // init maxDeap
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        int[] ret = new int[len - k + 1];
        ret[0] = maxHeap.peek();

        // sliding window
        int retIndex = 1;
        for (int j = k; j < len; j++) {
            int left = nums[j - k];
            maxHeap.remove(left);
            maxHeap.add(nums[j]);
            ret[++retIndex] = maxHeap.peek();
        }
       
        return ret;
    }
}

// 双端队列
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        
        int len = nums.length;
        int[] deQue = new int[k];

        List<Integer> deQue = new ArrayList<Integer>();
        int leftIndex = 0;
        int maxIndex = -1;
        int maxInteger = Integer.MAX_VALUE;
        int minInteger = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (i < k)
            {
                if (nums[i] > minInteger) {
                    ret[0] = nums[i];
                    maxIndex = i;
                    minInteger = nums[i];
                }
                deQue.add(nums[i]);
            } else { // sliding window
                
            }
        }
        return ret;
    }
}