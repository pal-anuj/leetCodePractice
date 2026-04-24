// Last updated: 24/04/2026, 09:13:20
1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3        int n = nums.length;
4        int[] res = new int[n - k + 1];
5
6        Deque<Integer> dq = new ArrayDeque<>();
7        int idx = 0;
8        for (int i = 0; i < n; i++) {
9
10            // remove ele from dq front which are not part of curr window
11            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1)
12                dq.pollFirst();
13
14            // maintaining decreasing order (remove smaller from back)
15            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
16                dq.removeLast();
17            }
18
19            dq.offer(i); // Add current index
20
21            //Window formed → take answer
22            if (i >= k - 1) {
23                res[idx++] = nums[dq.peekFirst()];
24            }
25        }
26
27        // // Brute force Time Complexity: O(n2)
28        // for(int i=0;i<=n-k;i++){
29        //     int maxEle= Integer.MIN_VALUE;
30        //     for(int j=i;j< n && j< i+k;j++){
31        //         if(maxEle < nums[j])
32        //             maxEle= nums[j];
33        //     }
34        //     res[i]= maxEle;
35        // }
36        return res;
37    }
38}