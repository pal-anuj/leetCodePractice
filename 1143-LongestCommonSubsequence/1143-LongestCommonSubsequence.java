// Last updated: 05/10/2026, 02:40:33
1class Solution {
2    public int longestCommonSubsequence(String s1, String s2) {
3        int n = s1.length();
4        int m = s2.length();
5        int[][] dp = new int[n + 1][m + 1];
6
7        for (int j = 0; j <= m; j++) {
8            dp[0][j] = 0;
9        }
10
11        for (int i = 0; i <= n; i++) {
12            dp[i][0] = 0;
13        }
14
15
16        for (int i = 1; i <= n; i++) {
17            for (int j = 1; j <= m; j++) {
18                if (s1.charAt(i - 1) == s2.charAt(j - 1))
19                    dp[i][j] = 1 + dp[i - 1][j - 1];
20                else {
21                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
22                }
23            }
24        }
25        return dp[n][m];
26
27        // // memoization 
28        // // tc= O(n * m), 
29        // // sc= O(n * m) + O(n + m)
30        // for (int i = 0; i <= n; i++) {
31        //     Arrays.fill(dp[i], -1);
32        // }
33
34        // return lcs(s1, s2, n, m, dp);
35    }
36
37    private int lcs(String s1, String s2, int idx1, int idx2, int[][] dp) {
38
39        if (idx1 == 0 || idx2 == 0) {
40            return 0;
41        }
42
43        if (dp[idx1][idx2] != -1) {
44            return dp[idx1][idx2];
45        }
46        if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1))
47            return dp[idx1][idx2] = 1 + lcs(s1, s2, idx1 - 1, idx2 - 1, dp);
48
49        return dp[idx1][idx2] = 0 + Math.max(lcs(s1, s2, idx1 - 1, idx2, dp), lcs(s1, s2, idx1, idx2 - 1, dp));
50
51        // // very brute force using 2 sets, 1 for each string    
52        // Set<String> set1 = new HashSet<>();
53        // set1.add("");
54
55        // for (char ch : s1.toCharArray()) {
56
57        //     Set<String> newSet = new HashSet<>();
58
59        //     for (String str : set1) {
60        //         newSet.add(str + ch);
61        //     }
62
63        //     set1.addAll(newSet);
64        // }
65
66        // Set<String> set2 = new HashSet<>();
67        // set2.add("");
68
69        // for (char ch : s2.toCharArray()) {
70
71        //     Set<String> newSet = new HashSet<>();
72
73        //     for (String str : set2) {
74        //         newSet.add(str + ch);
75        //     }
76
77        //     set2.addAll(newSet);
78        // }
79
80        // int count = 0;
81        // for (String str : set1) {
82        //     if (set2.contains(str) && str.length() > count) {
83        //         count = str.length();
84        //     }
85        // }
86        // return count;
87    }
88}