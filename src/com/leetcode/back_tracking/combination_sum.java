import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * q_39 solution
 * 1. backTracking
 * 2. backTracking + 剪枝
 * 3. backTracking + 剪枝 + space use int[]
 */

// 1. backTracking
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;

        // sort first
        Arrays.sort(candidates);
        generateCombination(candidates, target, res, new ArrayList<Integer>(), 0);
        return  res;
    }

    private void generateCombination(int[] candidates, int target, List<List<Integer>> res, ArrayList<Integer> prev, int index) {
        if (target < 0) return;
        else if (target == 0) res.add(new ArrayList<>(prev));
        else {
            for (int i = index; i < candidates.length ; i++) {
                prev.add(candidates[i]);
                generateCombination(candidates, target - candidates[i], res, prev, i); // not i + 1 cause we can reuse same elements
                prev.remove(prev.size() - 1);
            }
        }
    }
}

// 2. backTracking + 剪枝
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;

        // sort first
        Arrays.sort(candidates);
        generateCombination(candidates, target, res, new ArrayList<Integer>(), 0);
        return  res;
    }

    private void generateCombination(int[] candidates, int target, List<List<Integer>> res, ArrayList<Integer> prev, int index) {
        // remove target < 0 cause
        if (target == 0) res.add(new ArrayList<>(prev));
        else {
            for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
                prev.add(candidates[i]);
                generateCombination(candidates, target - candidates[i], res, prev, i); // not i + 1 cause we can reuse same elements
                prev.remove(prev.size() - 1);
            }
        }
    }
}

// 3. backTracking + 剪枝 + space use int[]
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;

        // sort first
        Arrays.sort(candidates);
        generateCombination(candidates, target, res, new int[target / candidates[0] + 1], 0); // make the biggest array
        return  res;
    }

    private void generateCombination(int[] candidates, int target, List<List<Integer>> res, int[] prev, int index) {
        if (target == 0) {
            ArrayList<Integer> currResult = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                currResult.add(prev[i]);
            }
            res.add(currResult);
            return;
        }
        else {
            for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
                prev[i] = candidates[i];
                generateCombination(candidates, target - candidates[i], res, prev, i); // not i + 1 cause we can reuse same elements
            }
        }
    }
}