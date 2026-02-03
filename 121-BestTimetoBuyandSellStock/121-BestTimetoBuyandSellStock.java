// Last updated: 03/02/2026, 07:31:11
1class Solution {
2    public int maxProfit(int[] prices) {
3        int profit=0;
4        int minPrice= prices[0];
5        for(int i=1;i<prices.length;i++){
6            if(prices[i] > minPrice)
7                profit= Math.max(profit, prices[i] - minPrice);
8            else
9                minPrice=prices[i];    
10        }
11        return profit;
12    }
13}