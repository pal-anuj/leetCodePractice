// Last updated: 16/04/2026, 05:37:09
class Solution {

    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); //Max Heap
    PriorityQueue<Integer> right = new PriorityQueue<>(); //Min Heap
    Map<Integer, Integer> delayed = new HashMap<>();
    int leftSize = 0, rightSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int size = (n - k) + 1;
        System.out.println(size);
        double[] res = new double[size];
        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }

        res[0] = getMedian(k);

        for (int i = k; i < n; i++) {

            remove(nums[i - k]);
            add(nums[i]);
            res[i-k+1] = getMedian(k);
        }

        return res;
    }



    private void add(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
            leftSize++;
        } else {
            right.offer(num);
            rightSize++;
        }
        rebalance();
    }

    private void remove(int num) {

        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= left.peek()) {
            leftSize--;
            if (num == left.peek())
                prune(left);

        } else {
            rightSize--;
            if (num == right.peek())
                prune(right);
        }
        rebalance();
    }

    private void rebalance() {
        if (leftSize > rightSize + 1) {
            right.offer(left.poll());
            leftSize--;
            rightSize++;
            prune(left);
        } else if (leftSize < rightSize) {
            left.offer(right.poll());
            leftSize++;
            rightSize--;
            prune(right);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0)
                    delayed.remove(num);
                heap.poll();

            } else
                break;
        }

    }
        private double getMedian(int k) {
        if (k % 2 == 1)
            return left.peek();

        return ((double) left.peek() + right.peek()) / 2.0;
    }
}