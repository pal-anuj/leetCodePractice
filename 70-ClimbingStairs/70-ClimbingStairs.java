// Last updated: 07/01/2026, 00:12:18
1class Solution {
2    public int climbStairs(int n) {
3        if(n <= 0) return 0;
4        if(n == 1) return 1;
5
6        int prev2= 1; // ways to reach step 0
7        int prev1= 1; // ways to reach step 1
8        int curr=0;
9
10        for(int i=2; i <= n; i++){
11            curr= prev1 + prev2;
12            prev2= prev1;
13            prev1= curr;
14        }
15        return curr;
16
17    }
18}