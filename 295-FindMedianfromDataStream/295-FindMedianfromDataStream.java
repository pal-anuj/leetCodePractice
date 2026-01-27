// Last updated: 27/01/2026, 16:18:50
1class Solution {
2
3    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); //Max Heap
4    PriorityQueue<Integer> right = new PriorityQueue<>(); //Min Heap
5    Map<Integer, Integer> delayed = new HashMap<>();
6    int leftSize = 0, rightSize = 0;
7
8    public double[] medianSlidingWindow(int[] nums, int k) {
9
10        int n = nums.length;
11        int size = (n - k) + 1;
12        System.out.println(size);
13        double[] res = new double[size];
14        for (int i = 0; i < k; i++) {
15            add(nums[i]);
16        }
17
18        res[0] = getMedian(k);
19
20        for (int i = k; i < n; i++) {
21
22            remove(nums[i - k]);
23            add(nums[i]);
24            res[i-k+1] = getMedian(k);
25        }
26
27        return res;
28    }
29
30
31
32    private void add(int num) {
33        if (left.isEmpty() || num <= left.peek()) {
34            left.offer(num);
35            leftSize++;
36        } else {
37            right.offer(num);
38            rightSize++;
39        }
40        rebalance();
41    }
42
43    private void remove(int num) {
44
45        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
46
47        if (num <= left.peek()) {
48            leftSize--;
49            if (num == left.peek())
50                prune(left);
51
52        } else {
53            rightSize--;
54            if (num == right.peek())
55                prune(right);
56        }
57        rebalance();
58    }
59
60    private void rebalance() {
61        if (leftSize > rightSize + 1) {
62            right.offer(left.poll());
63            leftSize--;
64            rightSize++;
65            prune(left);
66        } else if (leftSize < rightSize) {
67            left.offer(right.poll());
68            leftSize++;
69            rightSize--;
70            prune(right);
71        }
72    }
73
74    private void prune(PriorityQueue<Integer> heap) {
75        while (!heap.isEmpty()) {
76            int num = heap.peek();
77            if (delayed.containsKey(num)) {
78                delayed.put(num, delayed.get(num) - 1);
79                if (delayed.get(num) == 0)
80                    delayed.remove(num);
81                heap.poll();
82
83            } else
84                break;
85        }
86
87    }
88        private double getMedian(int k) {
89        if (k % 2 == 1)
90            return left.peek();
91
92        return ((double) left.peek() + right.peek()) / 2.0;
93    }
94}