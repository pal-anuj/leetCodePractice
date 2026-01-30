// Last updated: 30/01/2026, 23:49:54
1class Solution {
2
3    static class Pair {
4        int node, time;
5
6        Pair(int node, int time) {
7            this.node = node;
8            this.time = time;
9        }
10    }
11
12    public int networkDelayTime(int[][] times, int n, int k) {
13
14        List<List<Pair>> adjList = new ArrayList<>();
15        for (int i = 0; i <= n; i++)
16            adjList.add(new ArrayList<>());
17
18        for (int[] t : times) {
19            adjList.get(t[0]).add(new Pair(t[1], t[2]));
20        }
21
22        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
23        int dist[] = new int[n + 1];
24        Arrays.fill(dist, Integer.MAX_VALUE);
25        dist[k] = 0;
26
27        pq.offer(new Pair(k, 0));
28        while (!pq.isEmpty()) {
29
30            Pair curr = pq.poll();
31            int u = curr.node;
32            int time = curr.time;
33
34            if (time > dist[u])
35                continue;
36
37            for (Pair nei : adjList.get(u)) {
38                if (dist[nei.node] > dist[u] + nei.time) {
39                    dist[nei.node] = dist[u] + nei.time;
40                    pq.offer(new Pair(nei.node, dist[nei.node]));
41                }
42            }
43        }
44
45        int res = 0;
46        for (int i = 1; i <= n; i++) {
47            if (dist[i] == Integer.MAX_VALUE)
48                return -1;
49            res = Math.max(res, dist[i]);
50        }
51
52        return res;
53    }
54}