// Last updated: 12/03/2026, 08:11:07
1class Solution {
2    public int[][] updateMatrix(int[][] mat) {
3        int m = mat.length;
4        int n = mat[0].length;
5
6        Queue<int[]> q = new LinkedList<>();
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                if (mat[i][j] == 0)
10                    q.offer(new int[] { i, j });
11                else
12                    mat[i][j] = Integer.MAX_VALUE;
13            }
14        }
15
16        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
17
18        while (!q.isEmpty()) {
19            int[] cur = q.poll();
20            int r = cur[0];
21            int c = cur[1];
22
23            for (int[] d : dirs) {
24                int nr = r + d[0];
25                int nc = c + d[1];
26
27                if (nr >= 0 && nc >= 0 && 
28                    nr < m && nc < n &&
29                    mat[nr][nc] > mat[r][c] + 1) {
30                    mat[nr][nc] = mat[r][c] + 1;
31                    q.offer(new int[] { nr, nc });
32                }
33            }
34
35        }
36        return mat;
37    }
38}