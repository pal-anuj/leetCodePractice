// Last updated: 21/03/2026, 22:03:50
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        if (s.length() == 0)
4            return 0;
5        // if(s.length()==1) return 1;
6        int maxL = 0;
7        for (int i = 0; i < s.length(); i++) {
8            int len = 1;
9            maxL = Math.max(maxL, len);
10            HashSet<Character> hs = new HashSet<>();
11            hs.add(s.charAt(i));
12            for (int j = i + 1; j < s.length(); j++) {
13                if (hs.contains(s.charAt(j)))
14                    break;
15                else
16                    maxL = Math.max(maxL, ++len);
17                hs.add(s.charAt(j));
18            }
19        }
20        return maxL;
21    }
22}