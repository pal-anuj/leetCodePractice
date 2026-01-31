// Last updated: 31/01/2026, 08:55:21
1class Solution {
2    static class Pair {
3        int node, price; 
4        Pair(int node, int price) {
5            this.node = node; //destination city 
6            this.price = price; //cost of flight
7        }
8    }
9    static class State{
10        int node, cost, stops;
11        State(int node, int cost, int stops){
12            this.node= node; //current city
13            this.cost= cost; //total cost till now
14            this.stops= stops; //how many flights used so far
15        }
16    }
17
18    // n → number of cities
19    // flights → edges
20    // src → source city
21    // dst → destination city
22    // k → max allowed stops
23    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
24        
25        // Build Graph
26        List<List<Pair>> adjList= new ArrayList<>();
27        for(int i=0;i < n;i++)
28            adjList.add(new ArrayList<>());
29
30        for(int[] f : flights){
31            adjList.get(f[0]).add(new Pair(f[1], f[2])); // u → v with cost w
32        }
33
34        // Priority Queue (Min-heap by cost), Always process cheapest cost first
35        PriorityQueue<State> pq= new PriorityQueue<>((a,b) -> a.cost - b.cost);
36        pq.offer(new State(src, 0,0)); // Start at src , Cost = 0, Stops = 0
37        
38        // Best cost tracking table, best[node][stops] = minimum cost to reach node using stops flights, Why k + 2? = Stops can go up to k + 1 edges
39        int[][] best= new int[n][k+2];
40        for(int[] row : best)
41            Arrays.fill(row, Integer.MAX_VALUE);
42
43        best[src][0]= 0; // Cost to reach source with 0 stops = 0
44        
45        while(!pq.isEmpty()){
46
47            State curr= pq.poll();
48            int u= curr.node;
49            int cost= curr.cost;
50            int stops= curr.stops;
51
52            if(u==dst) return cost;
53            if(stops > k) continue;
54
55            for(Pair nei : adjList.get(u)){
56                int nextNode= nei.node;
57                int price= nei.price;
58
59                int newCost= cost + price;
60                int newStops= stops + 1;
61
62                if(newStops <= k + 1 && newCost < best[nextNode][newStops]){
63
64                    best[nextNode][newStops]= newCost;
65                    pq.offer(new State(nextNode, newCost, newStops));
66                }
67
68
69            }
70
71        }
72        return -1;
73        // Time	O(E log (V * K))
74        // Space	O(V * K)
75    }
76}