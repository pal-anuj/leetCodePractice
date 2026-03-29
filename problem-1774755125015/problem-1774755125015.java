// Last updated: 29/03/2026, 09:02:05
1class Solution {
2    public int firstMatchingIndex(String s) {
3        int l=0;
4        int h=s.length()-1;
5        while(l<=h){
6            if(s.charAt(l) == s.charAt(h))
7                return l;
8            l++; h--;
9        }
10        return -1;
11    }
12}