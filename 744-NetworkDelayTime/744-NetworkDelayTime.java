// Last updated: 16/04/2026, 05:36:58
class Solution {

    static class Pair {
        int node, time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adjList.add(new ArrayList<>());

        for (int[] t : times) {
            adjList.get(t[0]).add(new Pair(t[1], t[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        pq.offer(new Pair(k, 0));
        while (!pq.isEmpty()) {

            Pair curr = pq.poll();
            int u = curr.node;
            int time = curr.time;

            if (time > dist[u])
                continue;

            for (Pair nei : adjList.get(u)) {
                if (dist[nei.node] > dist[u] + nei.time) {
                    dist[nei.node] = dist[u] + nei.time;
                    pq.offer(new Pair(nei.node, dist[nei.node]));
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            res = Math.max(res, dist[i]);
        }

        return res;
    }
}