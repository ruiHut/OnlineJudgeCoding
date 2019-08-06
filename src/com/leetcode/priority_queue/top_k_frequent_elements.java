import java.util.*;

/**
 * TopK count in arr
 * 1. hashmap + heap (PriorityQueue 默认最小堆)
 * 2. Arrays.sort + bucket;
 */

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k > nums.length) return new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int key : map.keySet()) heap.offer(key);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++)
            res.add(heap.poll());

        return res;
    }
}

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k > nums.length)  return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        int len = nums.length;
        Arrays.sort(nums);

        int[] bucket = new int[len*3];
        int index = len;

        int maxCount = 0;
        int count = 1;
        int pre = nums[0];
        for (int i = 1; i < len; pre = nums[i++], count++) {
            if (pre != nums[i]) {
                bucket[index++] = pre;
                bucket[index++] = bucket[--count];
                bucket[count] = index - 2;
                if (count > maxCount) maxCount = count;

                count = 0;
            }
        }
        bucket[index++] = pre;
        bucket[index++] = bucket[--count];
        bucket[count] = index - 2;
        if (count > maxCount) maxCount = count;

        res.clear();
        for (int i = maxCount; i >= 0; --i) {
            for (int j = bucket[i]; j != 0; j = bucket[j+1]) {
                res.add(bucket[j]);
                if (res.size() == k) {
                    return res;
                }
            }
        }
        return res;
    }
}