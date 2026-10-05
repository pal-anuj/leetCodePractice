// Last updated: 06/10/2026, 01:11:47
1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m = obstacleGrid.length;
4        int n = obstacleGrid[0].length;
5        int[][] dp = new int[m][n];
6        for (int[] row : dp) {
7            Arrays.fill(row, -1);
8        }
9        return uniquePathsWithObstacles(obstacleGrid, m - 1, n - 1, dp);
10    }
11
12    private int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j, int[][] dp) {
13        if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1)
14            return 0;
15        if (i < 0 || j < 0)
16            return 0;
17        if (i == 0 && j == 0)
18            return 1;
19
20        if (dp[i][j] != -1)
21            return dp[i][j];
22        int up = uniquePathsWithObstacles(obstacleGrid, i - 1, j, dp);
23        int left = uniquePathsWithObstacles(obstacleGrid, i, j - 1, dp);
24        return dp[i][j] = up + left;
25    }
26}