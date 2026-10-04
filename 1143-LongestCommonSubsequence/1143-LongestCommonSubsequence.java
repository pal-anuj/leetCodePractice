// Last updated: 05/10/2026, 02:51:53
1class Solution {
2    public int longestCommonSubsequence(String s1, String s2) {
3        int n = s1.length();
4        int m = s2.length();
5
6        // most optimized
7        // tc= O(n*m)
8        // space= O(m)
9        int[] prev = new int[m + 1];
10        for (int j = 0; j <= m; j++) {
11            prev[j] = 0;
12        }
13
14        for (int i = 1; i <= n; i++) {
15            int[] cur = new int[m + 1];
16            for (int j = 1; j <= m; j++) {
17                if (s1.charAt(i - 1) == s2.charAt(j - 1))
18                    cur[j] = 1 + prev[j - 1];
19                else {
20                    cur[j] = Math.max(prev[j], cur[j - 1]);
21                }
22            }
23            prev = cur;
24        }
25        return prev[m];
26
27        // // tabulation
28        // // tc= O(n*m)
29        // // sc= O(n*m)
30        // int[][] dp = new int[n + 1][m + 1];
31        // for (int j = 0; j <= m; j++) {
32        //     dp[0][j] = 0;
33        // }
34
35        // for (int i = 0; i <= n; i++) {
36        //     dp[i][0] = 0;
37        // }
38
39        // for (int i = 1; i <= n; i++) {
40        //     for (int j = 1; j <= m; j++) {
41        //         if (s1.charAt(i - 1) == s2.charAt(j - 1))
42        //             dp[i][j] = 1 + dp[i - 1][j - 1];
43        //         else {
44        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
45        //         }
46        //     }
47        // }
48        // return dp[n][m];
49
50        // // memoization 
51        // // tc= O(n * m), 
52        // // sc= O(n * m) + O(n + m)
53        // for (int i = 0; i <= n; i++) {
54        //     Arrays.fill(dp[i], -1);
55        // }
56
57        // return lcs(s1, s2, n, m, dp);
58    }
59
60    private int lcs(String s1, String s2, int idx1, int idx2, int[][] dp) {
61
62        if (idx1 == 0 || idx2 == 0) {
63            return 0;
64        }
65
66        if (dp[idx1][idx2] != -1) {
67            return dp[idx1][idx2];
68        }
69        if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1))
70            return dp[idx1][idx2] = 1 + lcs(s1, s2, idx1 - 1, idx2 - 1, dp);
71
72        return dp[idx1][idx2] = 0 + Math.max(lcs(s1, s2, idx1 - 1, idx2, dp), lcs(s1, s2, idx1, idx2 - 1, dp));
73
74        // // very brute force using 2 sets, 1 for each string    
75        // Set<String> set1 = new HashSet<>();
76        // set1.add("");
77
78        // for (char ch : s1.toCharArray()) {
79
80        //     Set<String> newSet = new HashSet<>();
81
82        //     for (String str : set1) {
83        //         newSet.add(str + ch);
84        //     }
85
86        //     set1.addAll(newSet);
87        // }
88
89        // Set<String> set2 = new HashSet<>();
90        // set2.add("");
91
92        // for (char ch : s2.toCharArray()) {
93
94        //     Set<String> newSet = new HashSet<>();
95
96        //     for (String str : set2) {
97        //         newSet.add(str + ch);
98        //     }
99
100        //     set2.addAll(newSet);
101        // }
102
103        // int count = 0;
104        // for (String str : set1) {
105        //     if (set2.contains(str) && str.length() > count) {
106        //         count = str.length();
107        //     }
108        // }
109        // return count;
110    }
111}