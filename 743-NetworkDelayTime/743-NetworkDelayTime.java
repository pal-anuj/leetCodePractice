// Last updated: 05/09/2026, 05:27:46
1class Solution {
2    static class Pair {
3        int node, time;
4
5        Pair(int node, int time) {
6            this.node = node;
7            this.time = time;
8        }
9    }
10
11    public int networkDelayTime(int[][] times, int n, int k) {
12        
13        List<List<Pair>> graph= new ArrayList<>();
14        for(int i=0;i<=n;i++){
15            graph.add(new ArrayList<>());
16        }
17
18        for(int[] t : times){
19            System.out.println(t[2]);
20            graph.get(t[0]).add(new Pair(t[1], t[2]));
21        }
22
23        int[] dist= new int[n+1];
24        Arrays.fill(dist, Integer.MAX_VALUE);
25        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b) -> a.time- b.time);
26        pq.add(new Pair(k,0));
27        dist[k]=0;
28
29        while(!pq.isEmpty()){
30            Pair p= pq.poll();
31            int u= p.node;
32            int time= p.time;
33            System.out.println("node:"+u+", time:"+time);
34            for(Pair nei : graph.get(u)){
35                if(dist[nei.node] > dist[u]+ nei.time){
36                    dist[nei.node]= dist[u] + nei.time;
37                    pq.add(new Pair(nei.node, dist[nei.node]));
38                }
39            }
40        }
41
42        int res=0;
43        for(int i=1;i<=n;i++){
44            System.out.println("node:"+i+" , time:"+dist[i]);
45            if(dist[i]== Integer.MAX_VALUE){
46                return -1;
47            }
48            res= Math.max(res, dist[i]);
49        }
50        return res;
51    }
52}