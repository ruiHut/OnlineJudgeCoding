import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * q_46 solution
 * backTracking
 */

// backTracking
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;

        HashSet<Integer> left = new HashSet<>();
        for (int i : nums)
            left.add(i);

        backTracking(nums ,res, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }

    private void backTracking(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] isUsed) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!isUsed[i]) {
                temp.add(nums[i]);
                isUsed[i] = true;
                backTracking(nums, res, temp, isUsed);
                temp.remove(temp.size() - 1);
                isUsed[i] = false;
            }
        }
    }
}