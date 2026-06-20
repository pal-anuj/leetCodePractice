// Last updated: 20/06/2026, 23:34:43
1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4        int profit = 0;
5        int buy= prices[0];
6        for(int i=1;i<n;i++){
7            if(prices[i] > buy){
8                if(prices[i] - buy > profit)
9                    profit= prices[i] - buy;
10            }
11            else{
12                buy= prices[i];
13            }    
14        }
15        return profit;
16    }
17
18}