// Last updated: 12/03/2026, 07:09:27
1class Solution {
2    public int orangesRotting(int[][] grid) {
3        int rows = grid.length;
4        int cols = grid[0].length;
5
6        Queue<int[]> q = new LinkedList<>();
7
8        int fresh = 0;
9        for (int i = 0; i < rows; i++) {
10            for (int j = 0; j < cols; j++) {
11                if (grid[i][j] == 2)
12                    q.offer(new int[] { i, j });
13                if (grid[i][j] == 1)
14                    fresh++;
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
25
26                for (int[] d : dirs) {
27                    int nr = cur[0] + d[0];
28                    int nc = cur[1] + d[1];
29
30                    if (nr >= 0 && nc >= 0 && nr < rows && nc < cols &&
31                            grid[nr][nc] == 1) {
32                        grid[nr][nc] = 2;
33                        fresh--;
34                        q.offer(new int[] { nr, nc });
35                    }
36                }
37
38            }
39        }
40
41        return fresh == 0 ? time : -1;
42    }
43}