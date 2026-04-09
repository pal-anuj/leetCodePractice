// Last updated: 09/04/2026, 10:00:46
1class Solution {
2    public int trap(int[] height) {
3        int n = height.length;
4        // Optimized Approach time: O(n), Two pointer approach
5        int lmax = 0;
6        int rmax = 0;
7        int l = 0;
8        int r = n - 1;
9        int res = 0;
10        while (l < r) {
11            lmax = Math.max(lmax, height[l]);
12            rmax = Math.max(rmax, height[r]);
13
14            if (lmax < rmax) {
15                res += lmax - height[l++];
16            } else {
17                res += rmax - height[r--];
18            }
19        }
20        return res;
21
22        // Efficient time: O(n) , space: O(n) 
23        // int[] lmax = new int[n];
24        // lmax[0] = height[0];
25        // for (int i = 1; i < n; i++) {
26        //     lmax[i] = Math.max(lmax[i - 1], height[i]);
27        // }
28
29        // int[] rmax = new int[n];
30        // rmax[n - 1] = height[n - 1];
31        // for (int i = n - 2; i >= 0; i--) {
32        //     rmax[i] = Math.max(rmax[i + 1], height[i]);
33        // }
34
35        // int l = 0;
36        // int r = n - 1;
37        // int maxw = 0;
38        // for (int i = 1; i < n - 1; i++) {
39        //     maxw += Math.min(rmax[i], lmax[i]) - height[i];
40        // }
41        // return maxw;
42
43    }
44}