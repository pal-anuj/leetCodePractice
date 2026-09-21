// Last updated: 21/09/2026, 06:52:10
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
15    // tabulation time:O(n), space:O(n)
16    private int climbStairs(int n, int[] dp) {
17        dp[0] = 1; dp[1] = 1;
18
19        for (int i = 2; i <= n; i++) {
20            dp[i] = dp[i - 1] + dp[i - 2];
21        }
22
23        return dp[n];
24    }
25
26    // // memoization time:O(n), space:O(n)+O(n)
27    // private int climbStairs(int n, int[] dp) {
28    //     if (n == 0) return 1;
29    //     if (n == 1) return 1;
30
31    //     if (dp[n] != -1) return dp[n];
32    //     dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
33    //     return dp[n];
34    // }
35}