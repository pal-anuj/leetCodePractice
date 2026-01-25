// Last updated: 25/01/2026, 11:55:46
1class Solution {
2    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
3
4        
5        //build AdjList
6        List<List<Integer>> adjList = new ArrayList<>();
7        for (int i = 0; i < n; i++) {
8            adjList.add(new ArrayList<>());
9        }
10
11        for (int[] e : edges) {
12            adjList.get(e[0]).add(e[1]);
13            adjList.get(e[1]).add(e[0]);
14        }
15
16        int[] distx = bfs(x, adjList, n);
17        int[] disty = bfs(y, adjList, n);
18        int[] distz = bfs(z, adjList, n);
19
20        int count=0;
21
22        for(int i=0;i<n;i++){
23
24            int a= distx[i];
25            int b= disty[i];
26            int c= distz[i];    
27
28            int[] arr= {a,b,c};
29            Arrays.sort(arr);
30
31            if( (arr[0]*arr[0] + arr[1]* arr[1] ) == arr[2]* arr[2] )
32                count++;
33            
34        }
35
36        return count;
37    }
38
39    public int[] bfs(int st, List<List<Integer>> adjList, int n){
40
41        int dist[]= new int[n];
42        Arrays.fill(dist, -1);
43        Queue<Integer> q= new LinkedList<>();
44
45        q.offer(st);
46        dist[st]=0;
47
48        while(!q.isEmpty()){
49
50            int u= q.poll();
51
52            for(int v : adjList.get(u)){
53                if(dist[v] == -1){
54                    q.offer(v);
55                    dist[v]= dist[u]+1;
56                }
57            }
58        }
59        return dist;
60    }
61}