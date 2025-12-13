// Last updated: 14/12/2025, 00:09:53
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination)    
    {
        if(source == destination) return true;

        // Build adjacency list
        List<List<Integer>> adjList= new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]); //undirected graph
        }

        boolean[] visited= new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(source);
        visited[source]= true;

        while(!q.isEmpty()){
            int curr= q.poll();

            if(curr==destination) return true;

            //Directly get all neighbors through AdjList, timp complexity O(V+E)
            for(int nei : adjList.get(curr)){
                if(!visited[nei]){
                    q.add(nei);
                    visited[nei]=true;
                }
            }


            //  Scan edges every time this is making time Complexity as O(V*E)
            // for(int[] e: edges){
            //     int a= e[0];
            //     int b= e[1];
            //     if(a==curr && !visited[b]){
            //         q.add(b);
            //     }
            //     if(b==curr && !visited[a]){
            //         q.add(a);
            //     } 
            // }
        }
        return false;
    }
}