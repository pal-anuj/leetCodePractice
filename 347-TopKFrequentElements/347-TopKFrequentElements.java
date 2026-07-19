// Last updated: 19/07/2026, 23:39:26
1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3
4        Map<Integer, Integer> map = new HashMap<>();
5        for (int num : nums) {
6            map.put(num, map.getOrDefault(num, 0) + 1);
7        }
8
9        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
10        for (var entry : map.entrySet()) {
11            int[] element = new int[] { entry.getKey(), entry.getValue() };
12            pq.offer(element);
13            if (pq.size() > k) {
14                pq.poll();
15            }
16        }
17
18        int[] res = new int[pq.size()];
19        int i = 0;
20        while (!pq.isEmpty()) {
21            res[i++] = pq.poll()[0];
22        }
23        return res;
24    }
25}