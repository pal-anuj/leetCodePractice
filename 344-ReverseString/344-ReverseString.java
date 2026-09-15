// Last updated: 16/09/2026, 00:18:22
1class Solution {
2    public boolean isPalindrome(String s) {
3        s = s.replaceAll("[^a-zA-Z0-9]", "");
4        s = s.toLowerCase();
5        return isPalindromRec(s, 0);
6    }
7
8     private boolean isPalindromRec(String s, int i) {
9        if(i>= s.length()/2) return true;
10        if(s.charAt(i)!= s.charAt(s.length()-i-1))
11            return false;
12
13        return isPalindromRec(s,i+1);
14    }
15}