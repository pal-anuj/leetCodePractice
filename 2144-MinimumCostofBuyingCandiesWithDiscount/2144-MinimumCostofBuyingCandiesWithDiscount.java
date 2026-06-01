// Last updated: 02/06/2026, 00:24:24
1class Solution {
2    public int minimumCost(int[] cost) {
3
4        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
5        for (int candy : cost) {
6            pq.add(candy);
7        }
8
9        int totalCost = 0;
10        int count = 0;
11        while (!pq.isEmpty()) {
12            if (count == 2) {
13                pq.poll();
14                count = 0;
15                continue;
16            }
17            totalCost += pq.poll();
18            count++;
19        }
20        return totalCost;
21    }
22}