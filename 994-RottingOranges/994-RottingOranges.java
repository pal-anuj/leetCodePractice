// Last updated: 13/12/2025, 23:42:52
1class Solution {
2
3    public boolean isSafe(int nx, int ny, int n, int m){
4        return nx>=0 && nx<n && ny>=0 && ny<m;
5    }
6
7    public int orangesRotting(int[][] grid) {   
8 
9        int n=grid.length;
10        int m= grid[0].length;
11
12        // Queue to store cordinates of rotten oranges
13        Queue<int[]> q= new LinkedList<>();
14
15        // counter of elapsed time
16        int elapsedTime= 0;
17        int freshOrange=0;
18        
19        // push all rotten oranges to Queue
20        for(int i=0;i<n;i++){
21            for(int j=0;j<m;j++){
22                if(grid[i][j]==2){
23                    q.add(new int[]{i,j});
24                }else if(grid[i][j]==1)
25                    freshOrange++;
26            }
27        }
28
29        // direction for all 4 adjacent cells
30        int direction[][]= {{0,-1},{0,1},{-1,0},{1,0}};
31        
32        // perform multi source BFS
33        while(!q.isEmpty()){
34            boolean flag=false;
35            int size= q.size();
36
37            // process all orange at current level
38            for(int i=0;i<size;i++){
39                int[] cell= q.poll();
40
41                // check all 4 direction
42                for(int[] dir : direction){
43                    int nx= cell[0]+ dir[0];
44                    int ny= cell[1]+ dir[1];
45
46                    //if cell is safe and has fresh orange
47                    if(isSafe(nx, ny, n, m) && grid[nx][ny]==1)
48                    {
49                        grid[nx][ny]=2;
50                        q.add(new int[]{nx,ny});
51                        freshOrange--;
52                        flag=true;
53                    }
54                }
55            }
56
57            // atleast 1 orange got rotten, update time
58            if(flag)
59                elapsedTime++;
60        }
61
62        // // check if any fresh orange still available
63        // for(int i=0;i<n;i++){
64        //     for(int j=0;j<m;j++){
65        //         if(grid[i][j]==1){
66        //             return -1;
67        //         }
68        //     }
69        // }
70
71        return freshOrange==0? elapsedTime: -1;
72    }
73}