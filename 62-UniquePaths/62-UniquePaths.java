// Last updated: 06/10/2026, 00:28:28
1class Solution {
2    public int uniquePaths(int m, int n) {
3        int[][] dp = new int[m][n];
4        dp[0][0] = 1;
5        for (int i = 0; i < m; i++) {
6            for (int j = 0; j < n; j++) {
7                if (i == 0 && j == 0)
8                    dp[i][j] = 1;
9                else {
10                    int up = 0;
11                    int left = 0;
12                    if (i > 0)
13                        up = dp[i - 1][j];
14                    if (j > 0)
15                        left = dp[i][j - 1];
16                    dp[i][j] = up + left;
17                }
18            }
19        }
20        return dp[m - 1][n - 1];
21
22        // memoization tc: O(n*m), SC: O(n+m) + (n*m)
23        // for (int[] row : dp) {
24        //     Arrays.fill(row, -1);
25        // }
26        // return uniquePathsRec(m - 1, n - 1, dp);
27    }
28
29    private int uniquePathsRec(int i, int j, int[][] dp) {
30        if (i == 0 && j == 0)
31            return 1;
32        if (i < 0 || j < 0)
33            return 0;
34        if (dp[i][j] != -1)
35            return dp[i][j];
36        int up = uniquePathsRec(i - 1, j, dp);
37        int left = uniquePathsRec(i, j - 1, dp);
38        return dp[i][j] = up + left;
39    }
40}