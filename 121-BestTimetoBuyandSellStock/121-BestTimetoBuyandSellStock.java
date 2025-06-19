// Last updated: 19/06/2025, 13:05:58
class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int minBuyPrice=prices[0];
        for(int i =1;i<prices.length;i++)
        {
            if(prices[i]>prices[i-1])
                minBuyPrice= Math.min(minBuyPrice, prices[i-1]);   
                profit = Math.max(profit, prices[i]-minBuyPrice);
            }
        return profit;

    }
}