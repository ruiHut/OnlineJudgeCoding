import java.util.ArrayList;
import java.util.List;

/**
 * q_77 combinations
 * 1. backTracking
 * 2. backTracking + Alpha-beta (剪枝)
 */

// backTracking
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0 || k > n) return res;

        generateCombinations(n, k, res, 1,new ArrayList<>());
        return res;
    }

    private void generateCombinations(int n, int k, List<List<Integer>> res, int index, ArrayList<Integer> prev) {
        if (prev.size() == k) {
            res.add(new ArrayList<>(prev));
            return;
        }

        for (int i = index; i <= n; i++) {
            prev.add(i);
            generateCombinations(n, k, res, i + 1, prev);
            prev.remove(prev.size() - 1);
        }
    }
}

// backTracking + Alpha-beta
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0 || k > n) return res;

        generateCombinations(n, k, res, 1,new ArrayList<>());
        return res;
    }

    private void generateCombinations(int n, int k, List<List<Integer>> res, int index, ArrayList<Integer> prev) {
        if (prev.size() == k) {
            res.add(new ArrayList<>(prev));
            return;
        }

        for (int i = index; i <= n - k - (prev.size()) + 1; i++) {
            prev.add(i);
            generateCombinations(n, k, res, i + 1, prev);
            prev.remove(prev.size() - 1);
        }
    }
}