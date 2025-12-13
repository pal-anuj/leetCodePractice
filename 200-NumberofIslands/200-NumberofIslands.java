// Last updated: 14/12/2025, 01:00:15
1class Solution {
2    public int numIslands(char[][] grid) {
3        int n=grid.length;
4        int m=grid[0].length;
5
6        boolean visited[][]= new boolean[n][m];
7        int count=0;
8        for(int i=0;i<n;i++){
9            for(int j=0;j<m;j++){
10                if(grid[i][j]=='1' && visited[i][j]==false){
11                    BFS(i, j, grid, visited);
12                    count++;
13                }
14            }
15        }
16        return count;
17    }
18
19    public void BFS(int row, int col, char[][] grid, boolean[][] visited){
20        int n=grid.length;
21        int m=grid[0].length;
22
23        Queue<int[]> q= new LinkedList<>();
24        q.add(new int[]{row,col});
25        visited[row][col]= true;
26
27        // direction array left right top bottom
28        int[][] dirc= {{0,-1},{0,1},{-1,0},{1,0}};
29        while(!q.isEmpty()){
30            int[] cell= q.poll();
31
32            for(int[] dir : dirc){
33                int nx=cell[0] + dir[0];
34                int ny=cell[1] + dir[1];
35                // System.out.println("nx:"+nx);
36                // System.out.println("ny:"+ny);
37
38                if(nx>=0 && nx < n && ny >= 0 && ny < m 
39                    && grid[nx][ny]=='1' &&!visited[nx][ny])
40                {
41                    q.add(new int[]{nx,ny});
42                    visited[nx][ny]=true;
43                }
44            }
45        }
46    }
47}