// Last updated: 21/03/2026, 22:06:54
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int maxL = 0;
4        for (int i = 0; i < s.length(); i++) {
5            HashSet<Character> hs = new HashSet<>();
6            for (int j = i; j < s.length(); j++) {
7                if (hs.contains(s.charAt(j)))
8                    break;
9
10                maxL = Math.max(maxL, j - i + 1);
11                hs.add(s.charAt(j));
12            }
13        }
14        return maxL;
15    }
16}