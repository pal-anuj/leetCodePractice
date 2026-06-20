// Last updated: 20/06/2026, 23:15:29
1class Solution {
2    public int maxArea(int[] height) {
3        int n = height.length;
4        int res = 0;
5
6        int l = 0;
7        int r = n - 1;
8
9        while (l < r) {
10            int minh = Math.min(height[l], height[r]);
11            int cur = minh * (r - l);
12            System.out.println("minh=" + minh + ", l="+ l);
13            System.out.println("cur=" + cur);
14            if (cur > res)
15                res = cur;
16
17            if (height[l] >= height[r]) {
18                r--;
19            } else {
20                l++;
21            }
22
23        }
24
25        return res;
26    }
27}