// Last updated: 22/08/2026, 21:52:30
1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int col = matrix.length - 1;
4        int row = matrix[0].length - 1;
5
6        int col_l = 0;
7        int col_h = col;
8        while (col_l <= col_h) {
9            int col_m = col_l + (col_h - col_l) / 2;
10
11            if (target >= matrix[col_m][0]) {
12                if (target <= matrix[col_m][row]) {
13                    int l = 0;
14                    int h = row;
15                    while (l <= h) {
16                        int mid = l + (h - l) / 2;
17                        if (target == matrix[col_m][mid]) {
18                            return true;
19                        } else if (target < matrix[col_m][mid]) {
20                            h = mid - 1;
21                        } else {
22                            l = mid + 1;
23                        }
24                    }
25                    break;
26                } else {
27                    col_l = col_m + 1;
28                }
29            } else {
30                col_h = col_m - 1;
31            }
32
33        }
34
35        return false;
36    }
37}