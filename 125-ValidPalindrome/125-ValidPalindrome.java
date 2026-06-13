// Last updated: 13/06/2026, 12:23:29
1class Solution {
2    public boolean isPalindrome(String s) {
3        s = s.replaceAll("[^a-zA-Z0-9]", "");
4        s = s.toLowerCase();
5        int l = 0;
6        int r = s.length()-1;
7        while (l < r) {
8            if (s.charAt(l++) != s.charAt(r--))
9                return false;
10        }
11        return true;
12    }
13}