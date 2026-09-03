// Last updated: 03/09/2026, 07:52:05
1class Solution {
2    public boolean validPath(int n, int[][] edges, int source, int destination) {
3        if(edges.length==0) return true;
4        List<List<Integer>> graph = new ArrayList<>();
5        for (int i = 0; i < n; i++) {
6            graph.add(new ArrayList<>());
7        }
8        for (int[] edge : edges) {
9            int u = edge[0];
10            int v = edge[1];
11            graph.get(u).add(v);
12            graph.get(v).add(u);
13        }
14
15        Queue<Integer> q = new LinkedList<>();
16        boolean[] vis = new boolean[n];
17
18        q.offer(source);
19        vis[source] = true;
20
21        while (!q.isEmpty()) {
22
23            int u = q.poll();
24            for (int v : graph.get(u)) {
25                if (v == destination)
26                    return true;
27                if (!vis[v]) {
28                    vis[v] = true;
29                    q.offer(v);
30                }
31            }
32        }
33        return false;
34    }
35}