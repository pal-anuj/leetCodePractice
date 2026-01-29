// Last updated: 29/01/2026, 08:17:28
1class Solution {
2
3    public int[] findOrder(int numCourses, int[][] prerequisites) {
4
5        int[] res = new int[numCourses];
6
7        // Step:1 Check Cycle count
8        boolean[] vis = new boolean[numCourses];
9        boolean[] recPath = new boolean[numCourses];
10
11        for (int i = 0; i < numCourses; i++) {
12            if (!vis[i]) {
13                if (isCycleDFS(i, vis, recPath, prerequisites)){
14                    System.out.println("Recursion Found");
15                    return new int[0];
16                }
17                    
18            }
19        }
20        System.out.println("Recursion Found23");
21
22        // Step:2 Topological Sorted Order
23        Arrays.fill(vis, false);
24        Stack<Integer> st = new Stack<>();
25
26        for (int i = 0; i < numCourses; i++) {
27            if (!vis[i]) {
28                topoOrder(i, vis, st, prerequisites);
29            }
30        }
31
32        int i = 0;
33        while (st.size() > 0) {
34            res[i++] = st.pop();
35        }
36
37        return res;
38    }
39
40    private boolean isCycleDFS(int src, boolean[] vis, boolean[] recPath, int[][] edges) {
41        vis[src] = true;
42        recPath[src] = true;
43
44        for (int i = 0; i < edges.length; i++) {
45            int v = edges[i][0];
46            int u = edges[i][1];
47
48            if (u == src) {
49                if (!vis[v]) {
50                    if (isCycleDFS(v, vis, recPath, edges))
51                        return true;
52                } else if (recPath[v])
53                    return true;
54
55            }
56
57        }
58
59        recPath[src] = false;
60        return false;
61    }
62
63    private void topoOrder(int src, boolean[] vis, Stack<Integer> st, int[][] edges) {
64        vis[src] = true;
65
66        for (int i = 0; i < edges.length; i++) {
67            int v = edges[i][0];
68            int u = edges[i][1];
69
70            if (u == src) {
71                if (!vis[v]) {
72                    topoOrder(v, vis, st, edges);
73                }
74            }
75        }
76
77        st.push(src);
78    }
79
80}