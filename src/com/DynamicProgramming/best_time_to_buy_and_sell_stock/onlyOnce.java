/**
 * 121. sell and buy only once
 * 1 . fuck it for once time, remind minCost and maxProfix
 */

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int minCost = prices[0], maxProfix = 0; 
        for (int i = 1; i < prices.length; i++) {
            int curPrice = prices[i];
            if (curPrice <= minCost) minCost = curPrice; 
            else maxProfix = (curPrice - minCost) - maxProfix > 0 ? curPrice - minCost : maxProfix;
        }
        return maxProfix;
     }
}