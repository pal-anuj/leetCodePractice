// Last updated: 06/10/2026, 01:35:11
1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m = obstacleGrid.length;
4        int n = obstacleGrid[0].length;
5
6        // most optimized, time: O(n*m), space: O(n)
7        int[] prev = new int[n];
8        for (int i = 0; i < m; i++) {
9            int[] cur = new int[n];
10            for (int j = 0; j < n; j++) {
11                if (obstacleGrid[i][j] == 1)
12                    cur[j] = 0;
13                else if (i == 0 && j == 0)
14                    cur[j] = 1;
15                else {
16                    int up = 0;
17                    int left = 0;
18                    if (i > 0)
19                        up = prev[j];
20                    if (j > 0)
21                        left = cur[j - 1];
22
23                    cur[j] = (up + left);
24                }
25            }
26            prev = cur;
27        }
28        return prev[n - 1];
29
30        // int[][] dp = new int[m][n];
31
32        // // Tabulation
33        // for (int i = 0; i < m; i++) {
34        //     for (int j = 0; j < n; j++) {
35        //         if(obstacleGrid[i][j]==1)
36        //             dp[i][j] = 0;
37        //         else if (i == 0 && j == 0)
38        //             dp[i][j] = 1;
39        //         else {
40        //             int up = 0;
41        //             int left = 0;
42        //             if (i > 0)
43        //                 up = dp[i - 1][j];
44        //             if (j > 0)
45        //                 left = dp[i][j - 1];
46
47        //             dp[i][j] = (up + left);
48        //         }
49        //     }
50        // }
51        // return dp[m - 1][n - 1];
52
53        // Memoization 
54        // for (int[] row : dp) {
55        //     Arrays.fill(row, -1);
56        // }
57        // return uniquePathsWithObstacles(obstacleGrid, m - 1, n - 1, dp);
58    }
59
60    private int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, int[][] dp) {
61        if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1)
62            return 0;
63        if (i < 0 || j < 0)
64            return 0;
65        if (i == 0 && j == 0)
66            return 1;
67
68        if (dp[i][j] != -1)
69            return dp[i][j];
70        int up = uniquePathsWithObstacles(obstacleGrid, i - 1, j, dp);
71        int left = uniquePathsWithObstacles(obstacleGrid, i, j - 1, dp);
72        return dp[i][j] = up + left;
73    }
74}