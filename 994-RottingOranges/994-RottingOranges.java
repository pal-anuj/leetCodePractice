// Last updated: 13/12/2025, 23:38:03
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
17
18        // push all rotten oranges to Queue
19        for(int i=0;i<n;i++){
20            for(int j=0;j<m;j++){
21                if(grid[i][j]==2){
22                    q.add(new int[]{i,j});
23                }
24            }
25        }
26
27        // direction for all 4 adjacent cells
28        int direction[][]= {{0,-1},{0,1},{-1,0},{1,0}};
29        
30        // perform multi source BFS
31        while(!q.isEmpty()){
32            boolean flag=false;
33            int size= q.size();
34
35            // process all orange at current level
36            for(int i=0;i<size;i++){
37                int[] cell= q.poll();
38                int x= cell[0];
39                int y= cell[1];
40
41                // check all 4 direction
42                for(int[] dir : direction){
43                    int nx= x+ dir[0];
44                    int ny= y+ dir[1];
45
46                    //if cell is safe and has fresh orange
47                    if(isSafe(nx, ny, n, m) && grid[nx][ny]==1)
48                    {
49                        grid[nx][ny]=2;
50                        q.add(new int[]{nx,ny});
51                        flag=true;
52                    }
53                }
54            }
55
56            // atleast 1 orange got rotten, update time
57            if(flag)
58                elapsedTime++;
59        }
60
61        // check if any fresh orange still available
62        for(int i=0;i<n;i++){
63            for(int j=0;j<m;j++){
64                if(grid[i][j]==1){
65                    return -1;
66                }
67            }
68        }
69
70        return elapsedTime;
71    }
72}