// Last updated: 21/05/2026, 23:47:51
1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        HashMap<Integer, Integer> freqCount = new HashMap<>();
4        for (int num : nums) {
5            freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
6        }
7
8        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
9        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
10            pq.offer(new int[] { entry.getKey(), entry.getValue() });
11
12            if (pq.size() > k)
13                pq.poll();
14        }
15
16        int[] res = new int[pq.size()];
17        int i = 0;
18        while (!pq.isEmpty()) {
19            res[i++] = pq.poll()[0];
20        }
21
22        return res;
23    }
24}