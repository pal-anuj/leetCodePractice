// Last updated: 13/12/2025, 08:29:17
1class Solution {
2    public boolean validPath(int n, int[][] edges, int source, int destination)    
3    {
4        if(source == destination) return true;
5
6        // Build adjacency list
7        List<List<Integer>> adjList= new ArrayList<>();
8        for(int i=0;i<n;i++){
9            adjList.add(new ArrayList<>());
10        }
11
12        for(int[] e : edges){
13            adjList.get(e[0]).add(e[1]);
14            adjList.get(e[1]).add(e[0]); //undirected graph
15        }
16
17        boolean[] visited= new boolean[n];
18        Queue<Integer> q = new LinkedList<>();
19        
20        q.add(source);
21        visited[source]= true;
22
23        while(!q.isEmpty()){
24            int curr= q.poll();
25
26            if(curr==destination) return true;
27
28            //Directly get all neighbors through AdjList, timp complexity O(V+E)
29            for(int nei : adjList.get(curr)){
30                if(!visited[nei]){
31                    q.add(nei);
32                    visited[nei]=true;
33                }
34            }
35
36
37            //  Scan edges every time this is making time Complexity as O(V*E)
38            // for(int[] e: edges){
39            //     int a= e[0];
40            //     int b= e[1];
41            //     if(a==curr && !visited[b]){
42            //         q.add(b);
43            //     }
44            //     if(b==curr && !visited[a]){
45            //         q.add(a);
46            //     } 
47            // }
48        }
49        return false;
50    }
51}