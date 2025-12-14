// Last updated: 14/12/2025, 10:12:42
class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean visited[][]= new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    BFS(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void BFS(int row, int col, char[][] grid, boolean[][] visited){
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{row,col});
        visited[row][col]= true;

        // direction array left right top bottom
        int[][] dirc= {{0,-1},{0,1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int[] cell= q.poll();

            for(int[] dir : dirc){
                int nx=cell[0] + dir[0];
                int ny=cell[1] + dir[1];
                // System.out.println("nx:"+nx);
                // System.out.println("ny:"+ny);

                if(nx>=0 && nx < n && ny >= 0 && ny < m 
                    && grid[nx][ny]=='1' &&!visited[nx][ny])
                {
                    q.add(new int[]{nx,ny});
                    visited[nx][ny]=true;
                }
            }
        }
    }
}