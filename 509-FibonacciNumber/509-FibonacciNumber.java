// Last updated: 21/09/2026, 06:49:25
1class Solution {
2    public int climbStairs(int n) {
3        int[] dp = new int[n + 1];
4        Arrays.fill(dp, -1);
5        return climbStairs(n, dp);
6
7        // // recursion approach
8        // if (n == 0) return 1;
9        // if (n == 1) return 1;
10        // int left = climbStairs(n - 1);
11        // int right = climbStairs(n - 2);
12        // return left + right;
13    }
14
15    // memoization
16    private int climbStairs(int n, int[] dp) {
17        if (n == 0) return 1;
18        if (n == 1) return 1;
19
20        if (dp[n] != -1) return dp[n];
21        dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
22        return dp[n];
23    }
24}