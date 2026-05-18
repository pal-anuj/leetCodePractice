// Last updated: 18/05/2026, 23:53:56
1class Solution {
2    public int mySqrt(int x) {
3        int res = 0;
4        int l = 1;
5        int h = x;
6        if (x == 0)
7            return 0;
8        while (l <= h) {
9            int mid = l + (h - l) / 2;
10            long sqr = (long) mid * mid;
11            if (sqr == x)
12                return mid;
13            else if (sqr > x) {
14                h = mid - 1;
15            } else {
16                res = mid;
17                l = mid + 1;
18            }
19        }
20        return res;
21
22        // // Brute force approach
23        // for (int i = 1; i <= x; i++) {
24        //     int sqr = i * i;
25        //     if (sqr == x)
26        //         return i;
27        //     else if (sqr < x)
28        //         res = i;
29        //     else
30        //         return res;
31        // }
32        // return res;
33    }
34}