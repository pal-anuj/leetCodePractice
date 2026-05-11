// Last updated: 11/05/2026, 09:59:03
1class Solution {
2
3    public int maxProfit(int[] prices) {
4        int n = prices.length;
5        // dp[idx][buy]
6        int[][] dp = new int[n + 1][2];
7        dp[n][0] = dp[n][1] = 0;
8        for (int idx = n - 1; idx >= 0; idx--) {
9            for (int buy = 0; buy <= 1; buy++) {
10                if (dp[idx][buy] != 0)
11                    return dp[idx][buy];
12
13                int profit;
14
15                // If we can buy
16                if (buy == 1) {
17                    profit = Math.max(-prices[idx] + dp[idx + 1][0], // buy
18                            dp[idx + 1][1]); // skip
19                } else {
20                    // If we currently hold stock, we can sell
21                    profit = Math.max(prices[idx] + dp[idx + 1][1], // sell
22                            dp[idx + 1][0]); // skip   
23                }
24
25                // Store result
26                dp[idx][buy] = profit;
27
28            }
29        }
30
31        return dp[0][1];
32
33        // Simple approach O(n)    
34
35        // int totalProfit = 0;
36        // for (int i = 1; i < n; i++) {
37        //     if (prices[i] > prices[i - 1]) {
38        //         totalProfit += prices[i] - prices[i - 1];
39        //     }
40        // }
41        // return totalProfit;
42    }
43
44    public int maxProfitRec(int[] prices, int idx, int buy, Integer[][] dp) {
45
46        // Base case
47        if (idx == prices.length)
48            return 0;
49
50        if (dp[idx][buy] != 0)
51            return dp[idx][buy];
52
53        int profit;
54
55        // If we can buy
56        if (buy == 1) {
57            profit = Math.max(-prices[idx] + maxProfitRec(prices, idx + 1, 0, dp), // buy
58                    maxProfitRec(prices, idx + 1, 1, dp)); // skip
59        } else {
60            // If we currently hold stock, we can sell
61            profit = Math.max(prices[idx] + maxProfitRec(prices, idx + 1, 1, dp), // sell
62                    maxProfitRec(prices, idx + 1, 0, dp)); // skip   
63        }
64
65        // Store result
66        dp[idx][buy] = profit;
67
68        return profit;
69    }
70}