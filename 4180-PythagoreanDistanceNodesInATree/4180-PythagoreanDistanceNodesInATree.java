// Last updated: 16/04/2026, 05:36:37
class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {

        
        //build AdjList
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        int[] distx = bfs(x, adjList, n);
        int[] disty = bfs(y, adjList, n);
        int[] distz = bfs(z, adjList, n);

        int count=0;

        for(int i=0;i<n;i++){

            int a= distx[i];
            int b= disty[i];
            int c= distz[i];    

            int[] arr= {a,b,c};
            Arrays.sort(arr);

            if( (arr[0]*arr[0] + arr[1]* arr[1] ) == arr[2]* arr[2] )
                count++;
            
        }

        return count;
    }

    public int[] bfs(int st, List<List<Integer>> adjList, int n){

        int dist[]= new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q= new LinkedList<>();

        q.offer(st);
        dist[st]=0;

        while(!q.isEmpty()){

            int u= q.poll();

            for(int v : adjList.get(u)){
                if(dist[v] == -1){
                    q.offer(v);
                    dist[v]= dist[u]+1;
                }
            }
        }
        return dist;
    }
}