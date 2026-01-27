// Last updated: 27/01/2026, 09:09:57
1class MedianFinder {
2
3    PriorityQueue<Integer> left; //Max Heap
4    PriorityQueue<Integer> right; //Min heap
5
6    public MedianFinder() {
7        left = new PriorityQueue<>(Collections.reverseOrder()); //max Heap  
8        right = new PriorityQueue<>(); //Min heap      
9    }
10
11    public void addNum(int num) {
12
13        if (left.isEmpty() || num <= left.peek()) {
14            left.offer(num);
15        } else
16            right.offer(num);
17
18        rebalance();
19    }
20
21    public void rebalance() {
22        if (left.size() > right.size() + 1)
23            right.offer(left.poll());
24        else if (left.size() < right.size())
25            left.offer(right.poll());
26    }
27
28    public double findMedian() {
29        if (left.size() > right.size())
30            return (double) left.peek();
31
32        return (double) (left.peek() + right.peek()) / 2;
33    }
34}
35
36/**
37 * Your MedianFinder object will be instantiated and called as such:
38 * MedianFinder obj = new MedianFinder();
39 * obj.addNum(num);
40 * double param_2 = obj.findMedian();
41 */