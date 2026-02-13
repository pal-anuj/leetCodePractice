// Last updated: 13/02/2026, 07:48:59
1
2class Solution {
3    public int climbStairs(int n) {
4
5        if (n == 1)
6            return n;
7        int t[] = new int[n + 1];
8        t[1] = 1;
9        t[2] = 2;
10
11        for (int i = 3; i <= n; i++) {
12            t[i] = t[i - 1] + t[i - 2];
13        }
14        return t[n];
15    }
16}
17