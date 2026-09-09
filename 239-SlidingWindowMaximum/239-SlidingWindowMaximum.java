// Last updated: 09/09/2026, 22:15:44
1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3        int n = nums.length;
4        int[] res = new int[n - k + 1];
5
6        Deque<Integer> dq = new ArrayDeque<>();
7        int j = 0;
8        for (int i = 0; i < n; i++) {
9
10            // Remove elements outside the window
11            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
12                dq.pollFirst();
13            }
14
15            // Remove smaller elements
16            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
17                dq.pollLast();
18            }
19
20            dq.offer(i);
21
22            // Window is ready   
23            if (i >= k - 1) {
24                res[j++] = nums[dq.peekFirst()];
25            }
26        }
27        
28        return res;
29    }
30}