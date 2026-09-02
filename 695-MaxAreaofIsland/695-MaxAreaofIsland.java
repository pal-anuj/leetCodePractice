// Last updated: 02/09/2026, 07:14:02
1class Solution {
2    public int maxAreaOfIsland(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5
6        int maxArea = 0;
7        for (int i = 0; i < n; i++) {
8            for (int j = 0; j < m; j++) {
9                if (grid[i][j] == 1) {
10                    int area = dfs(grid, i, j);
11                    maxArea = Math.max(maxArea, area);
12                }
13            }
14        }
15        return maxArea;
16    }
17
18    // private int bfs(int[][] grid, int r, int c) {
19    //     //BFS approach
20    //     Queue<int[]> q = new LinkedList<>();
21    //     int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
22
23    //     // Mark visited when adding to queue
24    //     q.add(new int[] { r, c });
25    //     grid[r][c] = 0;
26
27    //     int cellCount = 0;
28    //     while (!q.isEmpty()) {
29    //         int[] cur = q.poll();
30    //         int row = cur[0];
31    //         int col = cur[1];
32    //         cellCount++;
33
34    //         for (int[] d : dir) {
35    //             int nr = row + d[0];
36    //             int nc = col + d[1];
37
38    //             // Boundary + water check
39    //             if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
40    //                 q.offer(new int[] { nr, nc });
41    //                 // Mark visited immediately
42    //                 grid[nr][nc] = 0;
43    //             }
44    //         }
45
46    //     }
47    //     return cellCount;
48    // }
49
50    private int dfs(int[][] grid, int r, int c) {
51        // DFS approach
52
53        // Boundary + water check
54        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
55                grid[r][c] == 0) {
56            return 0;
57        }
58
59        grid[r][c] = 0;
60        int area = 1;
61        area += dfs(grid, r + 1, c);
62        area += dfs(grid, r - 1, c);
63        area += dfs(grid, r, c + 1);
64        area += dfs(grid, r, c - 1);
65
66        return area;
67    }
68}