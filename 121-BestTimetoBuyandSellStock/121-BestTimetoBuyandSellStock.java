// Last updated: 12/10/2026, 01:12:44
1class Solution {
2    public int maxProfit(int[] prices) {
3        int maxP=0;
4        int minP=prices[0];
5        for(int i=1;i< prices.length;i++){
6            if(maxP < prices[i]- minP){
7                maxP= prices[i] - minP;
8            }
9            if(minP > prices[i]){
10                minP= prices[i];
11            }
12        }
13        return maxP;
14    }
15}