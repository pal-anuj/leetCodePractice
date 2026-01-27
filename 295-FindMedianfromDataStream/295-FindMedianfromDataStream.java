// Last updated: 27/01/2026, 09:10:19
class MedianFinder {
    PriorityQueue<Integer> MinHeap, MaxHeap;

    public MedianFinder() {
        MinHeap = new PriorityQueue<>();
        MaxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
    }
    
    public void addNum(int num) {
        if(MinHeap.isEmpty() && MaxHeap.isEmpty()){
            MaxHeap.offer(num);
            return;
        }

        if(num <= MaxHeap.peek()){
            MaxHeap.offer(num);
            
            while(Math.abs(MaxHeap.size()-MinHeap.size()) > 1){
                int top = MaxHeap.poll();
                MinHeap.offer(top);
            }
            return;
        }

        MinHeap.offer(num);
        while(Math.abs(MaxHeap.size()-MinHeap.size()) > 1){
            int top = MinHeap.poll();
            MaxHeap.offer(top);
        }
    }
    
    public double findMedian() {
        if (MaxHeap.size() > MinHeap.size()) {
        return MaxHeap.peek();
    } else if (MinHeap.size() > MaxHeap.size()) {
        return MinHeap.peek();
    }
    return (MaxHeap.peek() + MinHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */