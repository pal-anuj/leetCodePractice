// Last updated: 06/10/2026, 01:27:28
1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m = obstacleGrid.length;
4        int n = obstacleGrid[0].length;
5        int[][] dp = new int[m][n];
6
7        // Tabulation
8        for (int i = 0; i < m; i++) {
9            for (int j = 0; j < n; j++) {
10                if(obstacleGrid[i][j]==1)
11                    dp[i][j] = 0;
12                else if (i == 0 && j == 0)
13                    dp[i][j] = 1;
14                else {
15                    int up = 0;
16                    int left = 0;
17                    if (i > 0)
18                        up = dp[i - 1][j];
19                    if (j > 0)
20                        left = dp[i][j - 1];
21
22                    dp[i][j] = up + left;
23                }
24            }
25        }
26        return dp[m - 1][n - 1];
27
28        // Memoization 
29        // for (int[] row : dp) {
30        //     Arrays.fill(row, -1);
31        // }
32        // return uniquePathsWithObstacles(obstacleGrid, m - 1, n - 1, dp);
33    }
34
35    private int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, int[][] dp) {
36        if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1)
37            return 0;
38        if (i < 0 || j < 0)
39            return 0;
40        if (i == 0 && j == 0)
41            return 1;
42
43        if (dp[i][j] != -1)
44            return dp[i][j];
45        int up = uniquePathsWithObstacles(obstacleGrid, i - 1, j, dp);
46        int left = uniquePathsWithObstacles(obstacleGrid, i, j - 1, dp);
47        return dp[i][j] = up + left;
48    }
49}