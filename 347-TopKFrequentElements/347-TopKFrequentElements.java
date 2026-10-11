// Last updated: 12/10/2026, 00:27:43
1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3
4        HashMap<Integer, Integer> freqCount = new HashMap<>();
5        for (int num : nums) {
6            freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
7        }
8
9        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(num -> freqCount.get(num)));
10
11        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
12            pq.offer(entry.getKey());
13            if (pq.size() > k) {
14                pq.poll();
15            }
16        }
17
18        int[] res = new int[k];
19        for (int i = 0; i < k; i++) {
20            res[i] = pq.poll();
21        }
22
23        // // Sort HashMap by freq, time= O(n + mlogm)
24        // List<Map.Entry<Integer, Integer>> entries= new ArrayList<>(freqCount.entrySet());
25        // entries.sort((a,b) -> b.getValue()- a.getValue() );
26
27        // int[] res= new int[k];
28        // for(int i=0;i<k;i++){
29        //     res[i]= entries.get(i).getKey();
30        // }
31
32        return res;
33
34    }
35}