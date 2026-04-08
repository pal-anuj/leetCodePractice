// Last updated: 08/04/2026, 10:00:45
1class Solution {
2    public int maxArea(int[] height) {
3        int n = height.length;
4        int res = 0;
5
6        int l = 0;
7        int r = n - 1;
8
9        // Efficinet apprach using 2 pointer
10        while (l < r) {
11            int minh = Math.min(height[l], height[r]);
12            int cur = (r - l) * minh;
13            res = Math.max(res, cur);
14
15            if (height[l] < height[r])
16                l++;
17            else if (height[l] > height[r])
18                r--;
19            else {
20                l++;
21                r--;
22            }
23        }
24
25        // //    naive approach
26        //     int cur = 0;
27        // for (int i = 0; i < n - 1; i++) {
28        //     for (int j = i + 1; j < n; j++) {
29        //         int minh = Math.min(height[i], height[j]);
30        //         int cur = (j - i) * minh;
31        //         res = Math.max(res, cur);
32        //     }
33        // }
34        return res;
35    }
36}