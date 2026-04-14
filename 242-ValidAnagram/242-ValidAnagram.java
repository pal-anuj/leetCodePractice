// Last updated: 14/04/2026, 23:13:36
1class Solution {
2    public boolean isAnagram(String s, String t) {
3        int[] freq= new int[26];
4        if(s.length() != t.length()) return false;
5        for(int i=0;i<s.length();i++){
6            freq[s.charAt(i)-'a']++;
7            freq[t.charAt(i)-'a']--;
8        }
9        for(int i=0;i<26;i++){
10            if(freq[i]!=0) return false;
11        }
12        return true;
13    }
14}