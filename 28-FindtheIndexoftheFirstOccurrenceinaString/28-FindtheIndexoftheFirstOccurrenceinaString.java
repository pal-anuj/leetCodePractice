// Last updated: 23/03/2026, 22:07:03
1class Solution {
2    public int strStr(String haystack, String needle) {
3        int n = haystack.length();
4        int m = needle.length();
5        for (int i = 0; i <= n - m; i++) {
6            int j;
7            for (j = 0; j < m; j++) {
8                if (haystack.charAt(i + j) != needle.charAt(j))
9                    break;
10            }
11            if (j == m)
12                return i;
13        }
14        return -1;
15    }
16}