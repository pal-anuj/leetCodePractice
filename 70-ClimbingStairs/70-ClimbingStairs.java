// Last updated: 13/02/2026, 07:59:06
1
2class Solution {
3    public int climbStairs(int n) {
4
5        // If there is only 1 step, there is exactly 1 way to climb it
6        // (take one single step)
7        if (n == 1)
8            return n;
9
10        // DP array where:
11        // t[i] = number of distinct ways to reach step i
12        // We use size (n + 1) so that index = step number (easy mapping)
13        int t[] = new int[n + 1];
14
15        // Base case 1:
16        // To reach step 1, only 1 way -> (1)
17        t[1] = 1;
18
19        // Base case 2:
20        // To reach step 2, two ways:
21        // (1 + 1) or (2)
22        t[2] = 2;
23
24        // For every step from 3 to n:
25        // You can reach step i in two ways:
26        // 1️⃣ From step (i - 1) by taking 1 step
27        // 2️⃣ From step (i - 2) by taking 2 steps
28        // Total ways = ways to (i - 1) + ways to (i - 2)
29        for (int i = 3; i <= n; i++) {
30            t[i] = t[i - 1] + t[i - 2];
31        }
32
33        // The answer is the number of ways to reach the top step n
34        return t[n];
35    }
36}
37