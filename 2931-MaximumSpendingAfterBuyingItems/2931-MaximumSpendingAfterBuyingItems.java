// Last updated: 11/04/2026, 08:16:37
1class Solution {
2    public int maxProfit(int[] prices) {
3        int profit = 0;
4        int n = prices.length;
5        int min = prices[0];
6        for (int i = 1; i < n; i++) {
7            if (prices[i] > min)
8                profit = Math.max(profit, prices[i] - min);
9            else
10                min = prices[i];
11        }
12        return profit;
13    }
14
15    public int maxProfit1(int[] prices) {
16        int profit = 0;
17        int minPrice = prices[0];
18        // for(int i=1;i<prices.length;i++){
19        //     if(prices[i] > minPrice)
20        //         profit= Math.max(profit, prices[i] - minPrice);
21        //     else
22        //         minPrice=prices[i];    
23        // }
24        return profit;
25    }
26}