// Last updated: 05/10/2026, 10:02:17
1class Solution {
2    public int uniquePaths(int m, int n) {
3        int[][] dp = new int[m + 1][n + 1];
4        for (int[] row : dp) {
5            Arrays.fill(row, -1);
6        }
7        return uniquePathsRec(m - 1, n - 1, dp);
8    }
9
10    private int uniquePathsRec(int i, int j, int[][] dp) {
11        if (i == 0 && j == 0) return 1;
12        if (i < 0 || j < 0) return 0;
13        if (dp[i][j] != -1)
14            return dp[i][j];
15        int up = uniquePathsRec(i - 1, j, dp);
16        int left = uniquePathsRec(i, j - 1, dp);
17        return dp[i][j] = up + left;
18    }
19}