// Last updated: 10/06/2026, 19:02:15
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int res = 0;
4        int l = 0;
5        HashMap<Character, Integer> map = new HashMap<>();
6        for (int r = 0; r < s.length(); r++) {
7            char ch = s.charAt(r);
8            if (map.containsKey(ch)) {
9                l = Math.max(l, map.get(ch) + 1);
10            }
11
12            map.put(ch, r);
13            res = Math.max(res, r - l + 1);
14        }
15        return res;
16    }
17}