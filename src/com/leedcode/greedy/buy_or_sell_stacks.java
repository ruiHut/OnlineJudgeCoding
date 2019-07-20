/**
 * solution:
 * 1. DFS check out all the position  o(N2)
 * 2. Greedy                          o(N)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }

        return profit;
    }
}