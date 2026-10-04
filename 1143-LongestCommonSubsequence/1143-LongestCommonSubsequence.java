// Last updated: 05/10/2026, 02:29:19
1class Solution {
2    public int longestCommonSubsequence(String s1, String s2) {
3        int n = s1.length();
4        int m = s2.length();
5        int[][] dp = new int[n + 1][m + 1];
6        
7
8
9        // // memoization 
10        // // tc= O(n * m), 
11        // // sc= O(n * m) + O(n + m)
12        for (int i = 0; i <= n; i++) {
13            Arrays.fill(dp[i], -1);
14        }
15
16        return lcs(s1, s2, n, m, dp);
17    }
18
19    private int lcs(String s1, String s2, int idx1, int idx2, int[][] dp) {
20
21        if (idx1 == 0 || idx2 == 0) {
22            return 0;
23        }
24
25        if (dp[idx1][idx2] != -1) {
26            return dp[idx1][idx2];
27        }
28        if (s1.charAt(idx1-1) == s2.charAt(idx2-1))
29            return dp[idx1][idx2]=1 + lcs(s1, s2, idx1 - 1, idx2 - 1, dp);
30        
31        return dp[idx1][idx2] = 0 + Math.max(lcs(s1, s2, idx1 - 1, idx2, dp), lcs(s1, s2, idx1, idx2 - 1, dp));
32
33        // // very brute force using 2 sets, 1 for each string    
34        // Set<String> set1 = new HashSet<>();
35        // set1.add("");
36
37        // for (char ch : s1.toCharArray()) {
38
39        //     Set<String> newSet = new HashSet<>();
40
41        //     for (String str : set1) {
42        //         newSet.add(str + ch);
43        //     }
44
45        //     set1.addAll(newSet);
46        // }
47
48        // Set<String> set2 = new HashSet<>();
49        // set2.add("");
50
51        // for (char ch : s2.toCharArray()) {
52
53        //     Set<String> newSet = new HashSet<>();
54
55        //     for (String str : set2) {
56        //         newSet.add(str + ch);
57        //     }
58
59        //     set2.addAll(newSet);
60        // }
61
62        // int count = 0;
63        // for (String str : set1) {
64        //     if (set2.contains(str) && str.length() > count) {
65        //         count = str.length();
66        //     }
67        // }
68        // return count;
69    }
70}