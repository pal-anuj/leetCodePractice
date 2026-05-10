// Last updated: 10/05/2026, 23:35:30
1class Solution {
2    public double myPow(double x, int n) {
3        if (n == 0)
4            return 1.0;
5        if (x == 0)
6            return 0.0;
7        if (x == 1)
8            return 1.0;
9        if (x == -1 && n % 2 == 1) {
10            return -1.0;
11        }
12        if (x == -1 && n % 2 != 1)
13            return 1.0;
14
15        long binForm = n;
16        if (n < 0) {
17            x = 1 / x;
18            binForm = -binForm;
19        }
20
21        double res = 1;
22        while (binForm > 0) {
23            if (binForm % 2 == 1) {
24                res *= x;
25            }
26            x *= x;
27            binForm /= 2;
28        }
29        return res;
30
31        // double res=x;
32        // for(int i=1;i<n;i++)
33        //     res= res*x;
34        // return res;
35    }
36}