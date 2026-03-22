// Last updated: 22/03/2026, 17:13:54
1class Solution {
2    public int diagonalSum(int[][] mat) {
3        int n = mat.length;
4        int sum = 0;
5
6        // Efficient Approach
7        for (int i = 0; i < n; i++) {
8            // primary diagonal
9            sum += mat[i][i];
10
11            // secondary diagonal
12            sum += mat[i][n - 1 - i];
13        }
14
15        if (n % 2 == 1)
16            sum -= mat[n / 2][n / 2];
17
18        // // Brute Force    
19        // for(int i=0;i<n;i++){
20        //     for(int j=0;j<n;j++){
21        //         // primary diagonal
22        //         if(i==j)
23        //             sum += mat[i][j];
24
25        //         // secondary diagonal
26        //         else if(i+j == n-1)
27        //             sum += mat[i][j];
28        //     }
29        // }
30
31        return sum;
32    }
33}