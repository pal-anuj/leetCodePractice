// Last updated: 22/03/2026, 17:19:14
1class Solution {
2    public int[][] transpose(int[][] matrix) {
3        int rows = matrix.length;
4        int cols = matrix[0].length;
5        int[][] res = new int[cols][rows];
6        for (int i = 0; i < rows; i++) {
7            for (int j = 0; j < cols; j++) {
8                res[j][i] = matrix[i][j];
9            }
10        }
11        return res;
12    }
13}