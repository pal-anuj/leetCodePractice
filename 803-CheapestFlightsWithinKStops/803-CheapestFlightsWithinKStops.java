// Last updated: 16/04/2026, 05:36:55
class Solution {
    static class Pair {
        int node, price; 
        Pair(int node, int price) {
            this.node = node; //destination city 
            this.price = price; //cost of flight
        }
    }
    static class State{
        int node, cost, stops;
        State(int node, int cost, int stops){
            this.node= node; //current city
            this.cost= cost; //total cost till now
            this.stops= stops; //how many flights used so far
        }
    }

    // n → number of cities
    // flights → edges
    // src → source city
    // dst → destination city
    // k → max allowed stops
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // Build Graph
        List<List<Pair>> adjList= new ArrayList<>();
        for(int i=0;i < n;i++)
            adjList.add(new ArrayList<>());

        for(int[] f : flights){
            adjList.get(f[0]).add(new Pair(f[1], f[2])); // u → v with cost w
        }

        // Priority Queue (Min-heap by cost), Always process cheapest cost first
        PriorityQueue<State> pq= new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.offer(new State(src, 0,0)); // Start at src , Cost = 0, Stops = 0
        
        // Best cost tracking table, best[node][stops] = minimum cost to reach node using stops flights, Why k + 2? = Stops can go up to k + 1 edges
        int[][] best= new int[n][k+2];
        for(int[] row : best)
            Arrays.fill(row, Integer.MAX_VALUE);

        best[src][0]= 0; // Cost to reach source with 0 stops = 0
        
        while(!pq.isEmpty()){

            State curr= pq.poll();
            int u= curr.node;
            int cost= curr.cost;
            int stops= curr.stops;

            if(u==dst) return cost;
            if(stops > k) continue;

            for(Pair nei : adjList.get(u)){
                int nextNode= nei.node;
                int price= nei.price;

                int newCost= cost + price;
                int newStops= stops + 1;

                if(newStops <= k + 1 && newCost < best[nextNode][newStops]){

                    best[nextNode][newStops]= newCost;
                    pq.offer(new State(nextNode, newCost, newStops));
                }


            }

        }
        return -1;
        // Time	O(E log (V * K))
        // Space	O(V * K)
    }
}