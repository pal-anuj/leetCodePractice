// Last updated: 23/06/2026, 07:25:05
1class Solution {
2
3    private boolean isSafe(char[][] board, int row, int col, char dig) {
4        //horizontally
5        for (int j = 0; j < 9; j++) {
6            if (board[row][j] == dig)
7                return false;
8        }
9
10        //vertically
11        for (int i = 0; i < 9; i++) {
12            if (board[i][col] == dig)
13                return false;
14        }
15
16        // square 
17        int srow = (row / 3) * 3;
18        int scol = (col / 3) * 3;
19        for (int i = srow; i <= srow + 2; i++) {
20            for (int j = scol; j <= scol + 2; j++) {
21                if (board[i][j] == dig)
22                    return false;
23            }
24        }
25        return true;
26    }
27
28    private boolean helper(char[][] board, int row, int col) {
29        if (row == 9)
30            return true;
31
32        int nextRow = row;
33        int nextCol = col + 1;
34        if (nextCol == 9) {
35            nextRow = row + 1;
36            nextCol = 0;
37        }
38
39        if (board[row][col] != '.')
40            return helper(board, nextRow, nextCol);
41
42        // place the digit
43        for (char dig = '1'; dig <= '9'; dig++) {
44            if (isSafe(board, row, col, dig)) {
45                board[row][col] = dig;
46                if (helper(board, nextRow, nextCol)) {
47                    return true;
48                }
49                board[row][col] = '.';
50            }
51        }
52        return false;
53    }
54
55    public void solveSudoku(char[][] board) {
56        helper(board, 0, 0);
57    }
58}