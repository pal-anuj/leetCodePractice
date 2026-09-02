// Last updated: 02/09/2026, 23:43:11
1class Solution {
2    public int orangesRotting(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5
6        int fresh = 0;
7        Queue<int[]> q = new LinkedList<>();
8        for (int i = 0; i < n; i++) {
9            for (int j = 0; j < m; j++) {
10                if (grid[i][j] == 2) {
11                    q.add(new int[] { i, j });
12                } else if (grid[i][j] == 1) {
13                    fresh++;
14                }
15            }
16        }
17
18        int time = 0;
19        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
20        while (!q.isEmpty() && fresh > 0) {
21            int size = q.size();
22            time++;
23            for (int i = 0; i < size; i++) {
24                int[] cur = q.poll();
25                for (int[] dir : dirs) {
26                    int nr = cur[0] + dir[0];
27                    int nc = cur[1] + dir[1];
28
29                    if (nr >= 0 && nc >= 0 && nr < n && nc < m &&
30                            grid[nr][nc] == 1) {
31                        q.offer(new int[] { nr, nc });
32                        grid[nr][nc] = 2;
33                        fresh--;
34                    }
35
36                }
37            }
38
39            
40        }
41
42        return fresh == 0 ? time : -1;
43    }
44}