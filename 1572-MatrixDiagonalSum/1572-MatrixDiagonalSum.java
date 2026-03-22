// Last updated: 22/03/2026, 20:05:27
1class Solution {
2    public List<Integer> spiralOrder(int[][] matrix) {
3        int n = matrix.length;
4        int m = matrix[0].length;
5        int left = 0;
6        int right = m - 1;
7        int top = 0;
8        int bottom = n - 1;
9        List<Integer> res = new LinkedList<>();
10
11        while (top <= bottom && left <= right) {
12            for (int i = left; i <= right; i++) {
13                res.add(matrix[top][i]);
14            }
15            top++;
16            for (int i = top; i <= bottom; i++) {
17                res.add(matrix[i][right]);
18            }
19            right--;
20            if (top <= bottom) {
21                for (int i = right; i >= left; i--) {
22                    res.add(matrix[bottom][i]);
23                }
24                bottom--;
25            }
26            if (left <= right) {
27                for (int i = bottom; i >= top; i--) {
28                    res.add(matrix[i][left]);
29                }
30                left++;
31            }
32        }
33
34        return res;
35    }
36}