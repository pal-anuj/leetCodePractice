// Last updated: 15/12/2025, 18:15:47
1class Solution {
2
3    int[][] dir= {{0,-1}, {0,1}, {-1,0}, {1,0}};
4    int n,m;
5
6    public List<List<Integer>> pacificAtlantic(int[][] heights) {
7        n= heights.length;
8        m= heights[0].length;
9
10        List<List<Integer>> res = new ArrayList<>();
11        
12        boolean[][] pac= new boolean[n][m];
13        boolean[][] atl= new boolean[n][m];
14
15        // pacific top row and left column
16        for(int row=0;row<n;row++)
17            DFS(row, 0, heights, pac);
18
19        for(int col=0;col<m;col++){
20            DFS(0, col, heights, pac);
21        }
22
23        // Atlantic -> bottom row and right column
24        for(int row=0;row<n;row++)
25            DFS(row, m-1, heights, atl);
26
27        for(int col=0;col < m;col++){
28            DFS(n-1, col, heights, atl);
29        }
30
31        // Collect cells reachable by both oceans
32        for(int i=0;i<n;i++){
33            for(int j=0;j<m;j++){
34                if(pac[i][j] && atl[i][j])
35                    res.add(Arrays.asList(i,j));
36            }
37
38        }
39
40        return res;
41    }
42
43    public void DFS(int row, int col, int[][] heights, boolean[][] visited){
44        visited[row][col]= true;
45
46        for(int[] d : dir){
47            int nr= row + d[0];
48            int nc= col + d[1];
49         
50            // remain inside grid
51            if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
52
53            // System.out.println("nr: "+nr);
54            // System.out.println("nc: "+nc+ ", m:"+m);   
55
56            // skip if already visited
57            if(visited[nr][nc]) continue;
58
59            //move only if next cell has height less than current
60            if(heights[row][col] > heights[nr][nc]) continue;
61
62            DFS(nr, nc, heights, visited);        
63        }
64    }
65}
66
67