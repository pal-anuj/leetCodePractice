// Last updated: 26/01/2026, 20:01:29
1class Solution {
2    public long nthSmallest(long n, int k) {
3
4        //DFS
5        n--; // zero-based
6        int B = 60; // max bits
7        long r = 0;
8
9        for (int i = B - 1; i > 0; i--) {
10            long c = comb(i - 1, k);
11
12            if (n >= c) {
13                n -= c;
14                k--;
15                r |= (1L << (i - 1));
16            }
17        }
18        return r;
19
20        /*
21        // Navie Approch but Time Limit Exceeded
22        long i = (1L << k) - 1;
23        long max= (1L << (k+19)) - 1;
24        System.out.println(max);
25        for (i = 1; i < max; i++) {
26        
27            int c = countOnes(i);
28            if (c == k)
29                n--;
30        
31            if (n == 0)
32                break;
33        }
34        return i;
35        */
36
37    }
38
39    // DFS Helper method to calculate nCr (combination)
40    private long comb(int n, int r) {
41        if (r < 0 || r > n)
42            return 0;
43        if (r == 0 || r == n)
44            return 1;
45
46        r = Math.min(r, n - r);
47        long res = 1;
48
49        for (int i = 1; i <= r; i++) {
50            res = res * (n - r + i) / i;
51        }
52        return res;
53    }
54
55    // naive approach helper
56    public static int countOnes(long n) {
57        int count = 0;
58
59        while (n > 0) {
60            n = n & (n - 1);
61            count++;
62        }
63        return count;
64    }
65}
66