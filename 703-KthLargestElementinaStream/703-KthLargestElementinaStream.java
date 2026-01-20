// Last updated: 20/01/2026, 10:53:20
1class KthLargest {
2    private int k;
3    private PriorityQueue<Integer> minHeap;
4
5    public KthLargest(int k, int[] nums) {
6        this.k = k;
7        minHeap = new PriorityQueue<>(k);
8
9        for (int num : nums) {
10            minHeap.offer(num);
11            if (minHeap.size() > k)
12                  minHeap.poll();  
13        }
14    }
15
16    public int add(int val) {
17        minHeap.offer(val);
18        if (minHeap.size() > k) {
19            minHeap.poll();
20        }
21        return minHeap.peek();
22    }
23}
24
25/**
26 * Your KthLargest object will be instantiated and called as such:
27 * KthLargest obj = new KthLargest(k, nums);
28 * int param_1 = obj.add(val);
29 */