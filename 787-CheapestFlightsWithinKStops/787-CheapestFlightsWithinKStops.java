// Last updated: 07/09/2026, 23:38:25
1class Solution {
2    static class Pair {
3        int node, price;
4
5        Pair(int node, int price) {
6            this.node = node;
7            this.price = price;
8        }
9    }
10
11    static class State {
12        int node, cost, stop;
13
14        State(int node, int cost, int stop) {
15            this.node = node;
16            this.cost = cost;
17            this.stop = stop;
18        }
19    }
20
21    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
22        List<List<Pair>> graph = new ArrayList<>();
23        for (int i = 0; i < n; i++) {
24            graph.add(new ArrayList<>());
25        }
26
27        for (int[] f : flights) {
28            graph.get(f[0]).add(new Pair(f[1], f[2]));
29        }
30
31        int[] costs = new int[n];
32        Arrays.fill(costs, Integer.MAX_VALUE);
33
34        Queue<State> q = new LinkedList<>();
35        q.offer(new State(src, 0, 0));
36        costs[src] = 0;
37
38        while (!q.isEmpty()) {
39            State s = q.poll();
40            int u = s.node;
41            int cost = s.cost;
42            int stops = s.stop;
43
44            // stops = number of flights used - 1
45            if (stops > k) {
46                continue;
47            }
48
49            for (Pair nei : graph.get(u)) {
50                int v = nei.node;
51                int wt = nei.price;
52                int newCost = cost + wt;
53
54                if (newCost < costs[v]) {
55                    costs[v] = newCost;
56                    q.offer(new State(v, newCost, stops + 1));
57                }
58            }
59        }
60
61        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
62    }
63}