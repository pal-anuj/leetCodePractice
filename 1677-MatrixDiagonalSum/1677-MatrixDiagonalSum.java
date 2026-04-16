// Last updated: 16/04/2026, 05:36:46
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        // Efficient Approach
        for (int i = 0; i < n; i++) {
            // primary diagonal
            sum += mat[i][i];

            // secondary diagonal
            sum += mat[i][n - 1 - i];
        }

        if (n % 2 == 1)
            sum -= mat[n / 2][n / 2];

        // // Brute Force    
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         // primary diagonal
        //         if(i==j)
        //             sum += mat[i][j];

        //         // secondary diagonal
        //         else if(i+j == n-1)
        //             sum += mat[i][j];
        //     }
        // }

        return sum;
    }
}