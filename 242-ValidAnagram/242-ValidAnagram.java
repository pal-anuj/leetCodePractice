// Last updated: 14/04/2026, 23:13:43
1class Solution {
2    public boolean isAnagram(String s, String t) {
3        int[] freq = new int[26];
4        if (s.length() != t.length())
5            return false;
6        for (int i = 0; i < s.length(); i++) {
7            freq[s.charAt(i) - 'a']++;
8            freq[t.charAt(i) - 'a']--;
9        }
10        for (int i = 0; i < 26; i++) {
11            if (freq[i] != 0)
12                return false;
13        }
14        return true;
15    }
16}