// Last updated: 01/03/2026, 09:19:35
1class Solution {
2    public String trimTrailingVowels(String s) {
3        
4        int end= s.length()-1;
5        while(end >=0 && isVowel(s.charAt(end)))
6            end--;
7
8        return s.substring(0, end+1);
9        
10    }
11    private boolean isVowel(char c){
12        return c == 'a' || c == 'e' || c == 'i' 
13            || c == 'o' || c == 'u';
14    }
15}