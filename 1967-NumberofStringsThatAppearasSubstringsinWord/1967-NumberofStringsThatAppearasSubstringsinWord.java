// Last updated: 22/02/2026, 00:24:58
1class Solution {
2    public int numOfStrings(String[] patterns, String word) {
3        int n = patterns.length;
4        int count = 0;
5        for (int i = 0; i < n; i++) {
6            if (word.contains(patterns[i]))
7                count++;
8        }
9        return count;
10    }
11}