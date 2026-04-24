// Last updated: 24/04/2026, 09:11:05
1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3        int n = nums.length;
4        int[] res = new int[n - k + 1];
5        int l = 0;
6        int r = 0;
7
8        // [1,3,-1,-3,5,3,6,7]
9        Deque<Integer> dq = new ArrayDeque<>();
10        int idx = 0;
11        for (int i = 0; i < n; i++) {
12
13            // remove ele from dq which are not part of curr window
14            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1)
15                dq.pollFirst();
16
17            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
18                dq.removeLast();
19            }
20
21            dq.offer(i);
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