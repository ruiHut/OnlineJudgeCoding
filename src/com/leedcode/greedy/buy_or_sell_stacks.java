/**
 * solution:
 * 1. DFS check out all the position  o(N2)
 * 2. Greedy                          o(N)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int profit = 0;

        if (len == 0) return profit;

        int curPrice = prices[0];
        for(int i = 1; i < len; i++) {
            int nextPrice = prices[i];
            if (curPrice > nextPrice) { 
                // sell it
                curPrice = nextPrice;
            } else {
                // buy it
                profit += nextPrice - curPrice;
                // sell it 
                curPrice = nextPrice;
            }
        }

        return profit;
    }
}