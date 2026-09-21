// Last updated: 21/09/2026, 05:44:12
1class Solution {
2    public int fib(int n) {
3        int[] dp = new int[n + 1];
4        Arrays.fill(dp, -1);
5        return fib(n, dp);
6    }
7
8    private int fib(int n, int[] dp) {
9        if (n <= 1)
10            return n;
11
12        if (dp[n] != -1)
13            return dp[n];
14
15        dp[n] = fib(n - 1) + fib(n - 2);
16        return dp[n];
17    }
18}