// Last updated: 12/10/2026, 20:45:13
1class Solution {
2    public boolean isPalindrome(String s) {
3        s = s.replaceAll("[^A-Za-z0-9]", "");
4        s = s.toLowerCase();
5        // System.out.println(s);
6        int l = 0;
7        int r = s.length() - 1;
8        while (l < r) {
9            if (s.charAt(l) != s.charAt(r)) {
10                return false;
11            }
12            l++;
13            r--;
14        }
15        return true;
16    }
17
18}