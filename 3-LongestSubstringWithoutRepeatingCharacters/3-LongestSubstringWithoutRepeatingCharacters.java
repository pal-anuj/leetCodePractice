// Last updated: 18/06/2026, 23:07:42
1class Solution {
2    public int longestSubstring(String s, int k) {
3        int maxlen = 0;
4        int curlen = 1;
5
6        for (int i = 0; i < s.length(); i++) {
7            int[] freq = new int[26];
8            for (int j = i; j < s.length(); j++) {
9                freq[s.charAt(j) - 'a']++;
10                boolean valid = true;
11                for (int c : freq) {
12                    if (c > 0 && c < k) {
13                        valid = false;
14                        break;
15                    }
16                }
17
18                if (valid) {
19                    maxlen = Math.max(maxlen, j - i + 1);
20                }
21            }
22        }
23        return maxlen;
24    }
25}