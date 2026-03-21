// Last updated: 21/03/2026, 22:35:51
1class Solution {
2    public int maximumWealth(int[][] accounts) {
3        int rows = accounts.length;
4        int cols = accounts[0].length;
5        int maxWealth = 0;
6        for (int i = 0; i < rows; i++) {
7            int wealth = 0;
8            for (int j = 0; j < cols; j++) {
9                wealth += accounts[i][j];
10            }
11            maxWealth = Math.max(maxWealth, wealth);
12        }
13        return maxWealth;
14    }
15}