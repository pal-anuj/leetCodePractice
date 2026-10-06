// Last updated: 06/10/2026, 22:23:35
1class Solution {
2    public int minPathSum(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int[][] dp = new int[m][n];
7        for (int[] row : dp) {
8            Arrays.fill(row, -1);
9        }
10        return minPathSum(grid, m - 1, n - 1, dp);
11    }
12
13    private int minPathSum(int[][] grid, int i, int j, int[][] dp) {
14        if (i == 0 && j == 0)
15            return grid[i][j];
16        if (i < 0 || j < 0)
17            return Integer.MAX_VALUE;
18
19        if (dp[i][j] != -1)
20            return dp[i][j];
21        int up = minPathSum(grid, i - 1, j, dp);
22        if (up != Integer.MAX_VALUE) {
23            up += grid[i][j];
24        }
25        int left = minPathSum(grid, i, j - 1, dp);
26        if (left != Integer.MAX_VALUE) {
27            left += grid[i][j];
28        }
29        return dp[i][j] = Math.min(up, left);
30    }
31}