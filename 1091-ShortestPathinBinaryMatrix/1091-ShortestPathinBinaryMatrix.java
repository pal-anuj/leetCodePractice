// Last updated: 12/03/2026, 07:29:28
1class Solution {
2    public int shortestPathBinaryMatrix(int[][] grid) {
3        int n = grid.length;
4
5        if (grid[0][0]==1 || grid[n - 1][n - 1] == 1)
6            return -1;
7
8        Queue<int[]> q = new LinkedList<>();
9        q.offer(new int[] { 0, 0 });
10
11        grid[0][0] = 1;
12
13        // 8-directionally
14        int[][] dirs = {
15                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 },
16                { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
17        };
18
19        while (!q.isEmpty()) {
20            int[] cur = q.poll();
21            int r = cur[0];
22            int c = cur[1];
23            int dist = grid[r][c];
24
25            if (r == n - 1 && c == n - 1)
26                return dist;
27
28            for (int[] d : dirs) {
29
30                int nr = r + d[0];
31                int nc = c + d[1];
32
33                if (nr >= 0 && nc >= 0 && nr < n && nc < n &&
34                        grid[nr][nc] == 0) {
35                    grid[nr][nc] = dist + 1;
36                    q.offer(new int[] { nr, nc });
37                }
38            }
39        }
40        return -1;
41    }
42}