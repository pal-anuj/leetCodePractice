// Last updated: 21/09/2026, 06:32:15
1class Solution {
2    public int fib(int n) {
3        // tabulation approach oberservation we found we only need
4        // prev and 2nd prev element, so we can do like this
5        if (n <= 1)
6            return n;
7        int prev = 1; // fib(1)
8        int prev2 = 0; // fib(0)
9
10        for (int i = 2; i <= n; i++) {
11            int curr = prev + prev2;
12            prev2 = prev;
13            prev = curr;
14        }
15        return prev;
16        // int[] dp = new int[n + 1];
17        // Arrays.fill(dp, -1);
18        // return fib(n, dp);
19    }
20
21    // // memoization --> dp + stack
22    // private int fib(int n, int[] dp) {
23    //     if (n <= 1)
24    //         return n;
25
26    //     if (dp[n] != -1)
27    //         return dp[n];
28
29    //     return dp[n] = fib(n - 1) + fib(n - 2);
30    // }
31
32    // tabulation dp + no stack 
33    // private int fib(int n, int[] dp){
34    //     dp[0]=0;
35    //     dp[1]=1;
36
37    //     for(int i=2;i<=n;i++){
38    //         dp[i]= dp[i-1] + dp[i-2];
39    //     }
40
41    //     return dp[n];
42    // }
43}