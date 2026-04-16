// Last updated: 16/04/2026, 05:36:49
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones)
            pq.offer(stone);

        while (pq.size() > 1) {
            int y = pq.poll(); // largest
            int x = pq.poll(); // second largest

            if (y != x)
                pq.offer(y - x);
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}