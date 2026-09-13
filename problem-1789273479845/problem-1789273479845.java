// Last updated: 13/09/2026, 09:54:39
1class Solution {
2    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
3        for(int i=0;i<n;i++){
4            rotateRowByK( n, grid, i, rowShift[i]);
5        }
6
7        for(int i=0;i<n;i++){
8            rotateColByK( n, grid, i, colShift[i]);
9        }
10
11        return grid;
12    }
13
14    private void rotateRowByK(int n, int[][] grid, int row, int k){
15        k = k % n;
16        // Right rotation
17        reverseRow(grid, row, 0, k-1);
18        reverseRow(grid, row, k, n-1);
19        reverseRow(grid, row, 0, n-1);
20    }
21
22     private void rotateColByK(int n, int[][] grid, int col, int k){
23         k = k % n;
24         // Down rotation
25        reverseCol(grid, col, 0, k-1);
26        reverseCol(grid, col, k, n-1);
27         reverseCol(grid, col, 0, n-1);
28    }
29
30    private void reverseRow(int[][] grid, int row, int left, int right){
31        while(left < right){
32            int temp= grid[row][left];
33            grid[row][left]= grid[row][right];
34            grid[row][right]=temp;
35            left++;
36            right--;
37        }
38    }
39
40    private void reverseCol(int[][] grid, int col, int top, int bottom){
41        while(top < bottom){
42            int temp= grid[top][col];
43            grid[top][col]= grid[bottom][col];
44            grid[bottom][col]=temp;
45            top++;
46            bottom--;
47        }
48    }
49}