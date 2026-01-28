// Last updated: 28/01/2026, 23:37:51
1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3
4        /* BFS Approach*/
5        // Step 1: Build graph
6        List<List<Integer>> adjList= new ArrayList<>();
7
8        for(int i=0;i < numCourses;i++){
9            adjList.add(new ArrayList<>());
10        }
11
12        int[] indegree= new int[numCourses];
13        for(int[] edge : prerequisites){
14            int course= edge[0];
15            int prereq= edge[1];
16
17            adjList.get(prereq).add(course);
18            indegree[course]++;
19        }
20
21        // Step 2: Add indegree 0 nodes
22        Queue<Integer> q= new LinkedList<>();
23        for(int i=0; i < numCourses; i++){
24
25            if(indegree[i]==0)
26                q.offer(i);
27        }
28
29
30        // Step 3: BFS Topological sort
31        int completed=0;
32        while(!q.isEmpty()){
33
34            int u= q.poll();
35            completed++;
36            
37            for(int v : adjList.get(u)){
38                indegree[v]--;
39                if(indegree[v]==0)
40                    q.offer(v);
41
42            }
43        }
44        
45        // Step 4: check if all courses done
46        return completed == numCourses;
47
48        /* BFS End */
49
50        /* DFS Approach
51        boolean[] vis = new boolean[numCourses];
52        boolean[] recPath = new boolean[numCourses];
53
54        for (int i = 0; i < numCourses; i++) {
55            if (!vis[i])
56                if (isCycleDFS(i, vis, recPath, prerequisites))
57                    return false;
58
59        }
60        return true;
61        */
62    }
63
64    private boolean isCycleDFS(int src, boolean[] vis, boolean[] recPath, int[][] edges) {
65
66        vis[src] = true;
67        recPath[src] = true;
68
69        for (int i = 0; i < edges.length; i++) {
70
71            int v = edges[i][0];
72            int u = edges[i][1];
73
74            if (u == src) {
75                if (!vis[v]) {
76                    if (isCycleDFS(v, vis, recPath, edges))
77                        return true;
78
79                } else if (recPath[v])
80                    return true;
81            }
82        }
83
84        recPath[src] = false;
85        return false;
86    }
87}