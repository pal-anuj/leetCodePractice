// Last updated: 04/03/2026, 00:47:32
1class Solution {
2    public static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
3
4    public int numIslands(char[][] grid) {
5
6        int n = grid.length;
7        int m = grid[0].length;
8        int count = 0;
9
10        boolean[][] vis = new boolean[n][m];
11        for (int i = 0; i < n; i++) {
12            for (int j = 0; j < m; j++) {
13                if (grid[i][j] == '1' && !vis[i][j]) {
14                    BFS(i, j, vis, grid);
15                    count++;
16                }
17            }
18        }
19        return count;
20    }
21
22    public void BFS(int i, int j, boolean[][] vis, char[][] grid) {
23
24        int n = grid.length;
25        int m = grid[0].length;
26        Queue<int[]> q = new LinkedList<>();
27        q.add(new int[] { i, j });
28        vis[i][j] = true;
29
30        while (!q.isEmpty()) {
31
32            int cell[] = q.poll();
33            int row = cell[0];
34            int col = cell[1];
35            for (int[] d : dir) {
36                int nr = row + d[0];
37                int nc = col + d[1];
38
39                if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == '1' && !vis[nr][nc]) {
40                    q.add(new int[] { nr, nc });
41                    vis[nr][nc] = true;
42                }
43            }
44        }
45    }
46}