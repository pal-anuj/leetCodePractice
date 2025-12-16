// Last updated: 16/12/2025, 09:01:26
1class Solution {
2    public int maxProfit(int[] prices) {
3        int profit=0;
4        int minp=prices[0];
5
6        for(int i=1;i<prices.length;i++){
7            minp= Math.min(minp, prices[i]);
8            profit= Math.max(profit, prices[i]-minp);
9        }  
10        return profit;    
11    }
12}
13            