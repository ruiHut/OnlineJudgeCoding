/**
 * 120 Triangle
 * 1. 回溯 o(2n)
 * 2. DP o(n)
 */

// C++
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        vector<int> mini = triangle[triangle.size() - 1];
        for (int i = triangle.size() -2; i >= 0; --i) {
            for (int j = 0; j < triangle[i].size(); j++) {
                mini[j] = triangle[i][j] + Math.min(mini[j], mini[j + 1]);
            }
        }
        return mini[0];       
        
    }
}