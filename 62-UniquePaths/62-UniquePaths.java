// Last updated: 06/10/2026, 00:45:17
1class Solution {
2    public int uniquePaths(int m, int n) {
3        
4        // most optimized time: O(n*m), space: O(n)
5        int[] prev = new int[n];
6        prev[0] = 1;
7        for (int i = 0; i < m; i++) {
8            int[] cur = new int[n];
9            for (int j = 0; j < n; j++) {
10                if (i == 0 && j == 0)
11                    cur[j] = 1;
12                else {
13                    int up = 0;
14                    int left = 0;
15                    if (i > 0)
16                        up = prev[j];
17                    if (j > 0)
18                        left = cur[j - 1];
19                    cur[j] = up + left;
20                }
21            }
22            prev = cur;
23        }
24        return prev[n - 1];
25
26        // int[][] dp = new int[m][n];
27        // dp[0][0] = 1;
28
29        // // Tabulation time: O(n*m) , space: O(n*m)
30        // for (int i = 0; i < m; i++) {
31        //     for (int j = 0; j < n; j++) {
32        //         if (i == 0 && j == 0)
33        //             dp[i][j] = 1;
34        //         else {
35        //             int up = 0;
36        //             int left = 0;
37        //             if (i > 0)
38        //                 up = dp[i - 1][j];
39        //             if (j > 0)
40        //                 left = dp[i][j - 1];
41        //             dp[i][j] = up + left;
42        //         }
43        //     }
44        // }
45        // return dp[m - 1][n - 1];
46
47        // memoization tc: O(n*m), SC: O(n+m) + (n*m)
48        // for (int[] row : dp) {
49        //     Arrays.fill(row, -1);
50        // }
51        // return uniquePathsRec(m - 1, n - 1, dp);
52    }
53
54    private int uniquePathsRec(int i, int j, int[][] dp) {
55        if (i == 0 && j == 0)
56            return 1;
57        if (i < 0 || j < 0)
58            return 0;
59        if (dp[i][j] != -1)
60            return dp[i][j];
61        int up = uniquePathsRec(i - 1, j, dp);
62        int left = uniquePathsRec(i, j - 1, dp);
63        return dp[i][j] = up + left;
64    }
65}