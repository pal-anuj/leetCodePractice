// Last updated: 07/10/2026, 00:15:43
1class Solution {
2    public int minPathSum(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        // more space optimize using Tabulation 
7        int[] prev = new int[n];
8        for (int i = 0; i < m; i++) {
9            int[] cur = new int[n];
10            for (int j = 0; j < n; j++) {
11                if (i == 0 && j == 0)
12                    cur[j] = grid[i][j];
13                else {
14                    int up = i > 0 ? prev[j] : Integer.MAX_VALUE;
15                    if (up != Integer.MAX_VALUE) {
16                        up += grid[i][j];
17                    }
18
19                    int left = j > 0 ? cur[j - 1] : Integer.MAX_VALUE;
20                    if (left != Integer.MAX_VALUE) {
21                        left += grid[i][j];
22                    }
23                    cur[j] = Math.min(up, left);
24                }
25            }
26            prev = cur;
27        }
28        return prev[n - 1];
29
30        // int[][] dp = new int[m][n];
31        // for (int i = 0; i < m; i++) {
32        //     for (int j = 0; j < n; j++) {
33        //         if (i == 0 && j == 0)
34        //             dp[i][j]= grid[i][j];
35        //         else {
36        //             int up = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
37        //             if (up != Integer.MAX_VALUE) {
38        //                 up += grid[i][j];
39        //             }
40
41        //             int left = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
42        //             if (left != Integer.MAX_VALUE) {
43        //                 left += grid[i][j];
44        //             }
45        //             dp[i][j] = Math.min(up, left);
46        //         }
47        //     }
48        // }
49
50        // return dp[m - 1][n - 1];
51
52        // for (int[] row : dp) {
53        //     Arrays.fill(row, -1);
54        // }
55        // return minPathSum(grid, m - 1, n - 1, dp);
56    }
57
58    private int minPathSum(int[][] grid, int i, int j, int[][] dp) {
59        if (i == 0 && j == 0)
60            return grid[i][j];
61        if (i < 0 || j < 0)
62            return Integer.MAX_VALUE;
63
64        if (dp[i][j] != -1)
65            return dp[i][j];
66        int up = minPathSum(grid, i - 1, j, dp);
67        if (up != Integer.MAX_VALUE) {
68            up += grid[i][j];
69        }
70        int left = minPathSum(grid, i, j - 1, dp);
71        if (left != Integer.MAX_VALUE) {
72            left += grid[i][j];
73        }
74        return dp[i][j] = Math.min(up, left);
75    }
76}