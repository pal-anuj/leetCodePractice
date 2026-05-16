// Last updated: 16/05/2026, 08:56:04
1class Solution {
2    public boolean canFinish(int[] piles, int k, int h) {
3        long hours = 0;
4        for (int p : piles) {
5            hours += (p + k - 1) / k;
6            // hours += Math.ceil((double) piles[j] / k);
7        }
8        return hours <= h;
9    }
10
11    public int minEatingSpeed(int[] piles, int h) {
12        int maxK = Integer.MIN_VALUE;
13        for (int p : piles)
14            maxK = Math.max(maxK, p);
15
16        int l = 1;
17        int r = maxK;
18        while (l < r) {
19            int mid = l + (r - l) / 2;
20            if (canFinish(piles, mid, h)) {
21                r = mid;
22            } else
23                l = mid + 1;
24        }
25        return l;
26
27        // int minK= maxK;
28        // while (l <= r) {
29        //     int mid = l + (r - l) / 2;
30        //     if (canFinish(piles, mid, h)) {
31        //         minK = mid;  // 
32        //         r = mid - 1;
33        //     } else
34        //         l = mid + 1;
35        // }
36        // return minK;
37
38        // // brute force
39
40        // for (int i = maxK; i >= 1; i--) {
41        //     double minH = 0;
42        //     for (int j = 0; j < n; j++) {
43        //         minH += Math.ceil((double) piles[j] / i);
44        //     }
45        //     if (minH <= h)
46        //         minK = i;
47        // }
48        // return minK;
49    }
50}