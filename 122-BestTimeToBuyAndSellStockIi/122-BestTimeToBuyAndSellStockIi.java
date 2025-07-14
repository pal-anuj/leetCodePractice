// Last updated: 15/07/2025, 00:27:44
class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
                totalProfit += (prices[i]-prices[i-1]);
        }
        return totalProfit;
    }
}