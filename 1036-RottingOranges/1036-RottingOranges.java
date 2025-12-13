// Last updated: 14/12/2025, 00:09:58
class Solution {

    public boolean isSafe(int nx, int ny, int n, int m){
        return nx>=0 && nx<n && ny>=0 && ny<m;
    }

    public int orangesRotting(int[][] grid) {   
 
        int n=grid.length;
        int m= grid[0].length;

        // Queue to store cordinates of rotten oranges
        Queue<int[]> q= new LinkedList<>();

        // counter of elapsed time
        int elapsedTime= 0;
        int freshOrange=0;
        
        // push all rotten oranges to Queue
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1)
                    freshOrange++;
            }
        }

        // direction for all 4 adjacent cells
        int direction[][]= {{0,-1},{0,1},{-1,0},{1,0}};
        
        // perform multi source BFS
        while(!q.isEmpty()){
            boolean flag=false;
            int size= q.size();

            // process all orange at current level
            for(int i=0;i<size;i++){
                int[] cell= q.poll();

                // check all 4 direction
                for(int[] dir : direction){
                    int nx= cell[0]+ dir[0];
                    int ny= cell[1]+ dir[1];

                    //if cell is safe and has fresh orange
                    if(isSafe(nx, ny, n, m) && grid[nx][ny]==1)
                    {
                        grid[nx][ny]=2;
                        q.add(new int[]{nx,ny});
                        freshOrange--;
                        flag=true;
                    }
                }
            }

            // atleast 1 orange got rotten, update time
            if(flag)
                elapsedTime++;
        }

        // // check if any fresh orange still available
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(grid[i][j]==1){
        //             return -1;
        //         }
        //     }
        // }

        return freshOrange==0? elapsedTime: -1;
    }
}