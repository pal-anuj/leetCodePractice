// Last updated: 15/07/2025, 00:27:45
class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int minBuyPrice=prices[0];
        for(int i =1;i<prices.length;i++)
        {
            if(prices[i] > minBuyPrice)
            {    
                //Keep update max Profit
                profit = Math.max(profit, prices[i]-minBuyPrice);
            }// if next price is low then will update it minBuyPrice
            else
                minBuyPrice=prices[i];
        }        
        return profit;

    }
}
            