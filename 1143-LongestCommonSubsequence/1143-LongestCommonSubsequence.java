// Last updated: 05/10/2026, 02:07:23
1class Solution {
2    public int longestCommonSubsequence(String s1, String s2) {
3        int n = s1.length();
4        int m = s2.length();
5        int[][] dp = new int[n + 1][m + 1];
6        for (int i = 0; i < n; i++) {
7            Arrays.fill(dp[i], -1);
8        }
9
10        return lcs(s1, s2, n - 1, m - 1, dp);
11    }
12
13    private int lcs(String s1, String s2, int idx1, int idx2, int[][] dp) {
14
15        if (idx1 < 0 || idx2 < 0) {
16            return 0;
17        }
18
19        if (dp[idx1][idx2] != -1) {
20            return dp[idx1][idx2];
21        }
22        if (s1.charAt(idx1) == s2.charAt(idx2))
23            return 1 + lcs(s1, s2, idx1 - 1, idx2 - 1, dp);
24        else
25            return dp[idx1][idx2] = 0 + Math.max(lcs(s1, s2, idx1 - 1, idx2, dp), lcs(s1, s2, idx1, idx2 - 1, dp));
26
27        // // very brute force using 2 sets, 1 for each string    
28        // Set<String> set1 = new HashSet<>();
29        // set1.add("");
30
31        // for (char ch : s1.toCharArray()) {
32
33        //     Set<String> newSet = new HashSet<>();
34
35        //     for (String str : set1) {
36        //         newSet.add(str + ch);
37        //     }
38
39        //     set1.addAll(newSet);
40        // }
41
42        // Set<String> set2 = new HashSet<>();
43        // set2.add("");
44
45        // for (char ch : s2.toCharArray()) {
46
47        //     Set<String> newSet = new HashSet<>();
48
49        //     for (String str : set2) {
50        //         newSet.add(str + ch);
51        //     }
52
53        //     set2.addAll(newSet);
54        // }
55
56        // int count = 0;
57        // for (String str : set1) {
58        //     if (set2.contains(str) && str.length() > count) {
59        //         count = str.length();
60        //     }
61        // }
62        // return count;
63    }
64}