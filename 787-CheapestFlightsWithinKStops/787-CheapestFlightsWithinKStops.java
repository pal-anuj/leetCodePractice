// Last updated: 31/01/2026, 08:43:36
1class Solution {
2    static class Pair {
3        int node, price;
4
5        Pair(int node, int price) {
6            this.node = node;
7            this.price = price;
8        }
9    }
10    static class State{
11        int node, cost, stops;
12        State(int node, int cost, int stops){
13            this.node= node;
14            this.cost= cost;
15            this.stops= stops;
16        }
17    }
18
19    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
20        
21        // Build Graph
22        List<List<Pair>> adjList= new ArrayList<>();
23        for(int i=0;i < n;i++)
24            adjList.add(new ArrayList<>());
25
26        for(int[] f : flights){
27            adjList.get(f[0]).add(new Pair(f[1], f[2]));
28        }
29
30        PriorityQueue<State> pq= new PriorityQueue<>((a,b) -> a.cost - b.cost);
31        pq.offer(new State(src, 0,0));
32        
33        int[][] best= new int[n][k+2];
34        for(int[] row : best)
35            Arrays.fill(row, Integer.MAX_VALUE);
36
37        best[src][0]= 0;
38        
39        while(!pq.isEmpty()){
40
41            State curr= pq.poll();
42            int u= curr.node;
43            int cost= curr.cost;
44            int stops= curr.stops;
45
46            if(u==dst) return cost;
47            if(stops > k) continue;
48
49            for(Pair nei : adjList.get(u)){
50                int nextNode= nei.node;
51                int price= nei.price;
52
53                int newCost= cost + price;
54                int newStops= stops + 1;
55
56                if(newCost < best[nextNode][newStops]){
57
58                    best[nextNode][newStops]= newCost;
59                    pq.offer(new State(nextNode, newCost, newStops));
60                }
61
62
63            }
64
65        }
66        return -1;
67    }
68}