// Last updated: 30/01/2026, 20:02:19
1class Solution {
2    public int kthSmallest(int[][] matrix, int k) {
3        
4
5        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
6
7        for(int i=0;i<matrix.length;i++){
8            for(int j=0;j<matrix[0].length;j++){
9                if(pq.size() < k){
10                    pq.add(matrix[i][j]);
11                }
12                else if(pq.size() > 0 && matrix[i][j] < pq.peek()){
13                    pq.poll();
14                    pq.add(matrix[i][j]);
15                }
16            }
17        }
18        return pq.size() > 0 ? pq.peek() : -1;
19    }
20}