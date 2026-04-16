// Last updated: 16/04/2026, 05:36:45
class Solution {
    public int maximumWealth(int[][] accounts) {
        int rows = accounts.length;
        int cols = accounts[0].length;
        int maxWealth = 0;
        for (int i = 0; i < rows; i++) {
            int wealth = 0;
            for (int j = 0; j < cols; j++) {
                wealth += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, wealth);
        }
        return maxWealth;
    }
}