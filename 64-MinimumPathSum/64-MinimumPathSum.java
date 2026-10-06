// Last updated: 07/10/2026, 00:08:00
1class Solution {
2    public int minPathSum(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int[][] dp = new int[m][n];
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                if (i == 0 && j == 0)
10                    dp[i][j]= grid[i][j];
11                else {
12                    int up = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
13                    if (up != Integer.MAX_VALUE) {
14                        up += grid[i][j];
15                    }
16
17                    int left = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
18                    if (left != Integer.MAX_VALUE) {
19                        left += grid[i][j];
20                    }
21                    dp[i][j] = Math.min(up, left);
22                }
23            }
24        }
25
26        return dp[m - 1][n - 1];
27
28        // for (int[] row : dp) {
29        //     Arrays.fill(row, -1);
30        // }
31        // return minPathSum(grid, m - 1, n - 1, dp);
32    }
33
34    private int minPathSum(int[][] grid, int i, int j, int[][] dp) {
35        if (i == 0 && j == 0)
36            return grid[i][j];
37        if (i < 0 || j < 0)
38            return Integer.MAX_VALUE;
39
40        if (dp[i][j] != -1)
41            return dp[i][j];
42        int up = minPathSum(grid, i - 1, j, dp);
43        if (up != Integer.MAX_VALUE) {
44            up += grid[i][j];
45        }
46        int left = minPathSum(grid, i, j - 1, dp);
47        if (left != Integer.MAX_VALUE) {
48            left += grid[i][j];
49        }
50        return dp[i][j] = Math.min(up, left);
51    }
52}