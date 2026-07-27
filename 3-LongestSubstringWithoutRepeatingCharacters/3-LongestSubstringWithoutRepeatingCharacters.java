// Last updated: 27/07/2026, 09:45:38
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int n = s.length();
4        Map<Character, Integer> map = new HashMap<>();
5        int l = 0;
6        int r = 0;
7        int maxLen = 0;
8
9        while (r < n) {
10            char c = s.charAt(r);
11            if (map.containsKey(c)) {
12                l = Math.max(l, map.get(c) + 1);
13            }
14
15            if (maxLen < (r - l + 1)) {
16                maxLen = r - l + 1;
17            }
18            map.put(c, r++);
19        }
20        return maxLen;
21    }
22}