// Last updated: 31/08/2026, 08:12:39
1class Solution {
2    public int numIslands(char[][] grid) {
3        int n= grid.length;
4        int m= grid[0].length;
5        int count=0;
6        boolean[][] vis= new boolean[n][m];
7        
8        for(int i=0;i<n;i++){
9            for(int j=0;j<m;j++){
10                if(grid[i][j]=='1' && !vis[i][j]){
11                    bfs(i, j, grid, vis);
12                    count++;
13                }
14            }
15        }
16        return count;
17    }
18
19    private void bfs(int row, int col, char[][] grid, boolean[][] vis){
20        int n=grid.length;
21        int m= grid[0].length;
22
23        Queue<int[]> q= new LinkedList<>();
24        q.add(new int[]{row, col});
25        vis[row][col]=true;
26
27        int[][] dirc= {{1,0}, {-1,0}, {0,1}, {0,-1}};
28
29        while(!q.isEmpty()){
30            int[] cell= q.poll();
31
32            for(int[] dir : dirc){
33                int nx= cell[0] + dir[0];
34                int ny= cell[1] + dir[1];
35
36                if(nx >= 0 && ny >= 0 && nx < n && ny < m 
37                    && grid[nx][ny]=='1' && !vis[nx][ny]){
38                    q.add(new int[]{nx, ny});
39                    vis[nx][ny]= true;
40                }
41            }
42        }
43    }
44}