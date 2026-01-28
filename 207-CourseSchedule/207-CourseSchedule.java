// Last updated: 28/01/2026, 10:29:59
1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3
4        boolean[] vis = new boolean[numCourses];
5        boolean[] recPath = new boolean[numCourses];
6
7        for (int i = 0; i < numCourses; i++) {
8            if (!vis[i])
9                if (isCycleDFS(i, vis, recPath, prerequisites))
10                    return false;
11
12        }
13        return true;
14    }
15
16    private boolean isCycleDFS(int src, boolean[] vis, boolean[] recPath, int[][] edges) {
17
18        vis[src] = true;
19        recPath[src] = true;
20
21        for (int i = 0; i < edges.length; i++) {
22
23            int v = edges[i][0];
24            int u = edges[i][1];
25
26            if (u == src) {
27                if (!vis[v]) {
28                    if (isCycleDFS(v, vis, recPath, edges))
29                        return true;
30
31                } else if (recPath[v])
32                    return true;
33            }
34        }
35
36        recPath[src] = false;
37        return false;
38    }
39}