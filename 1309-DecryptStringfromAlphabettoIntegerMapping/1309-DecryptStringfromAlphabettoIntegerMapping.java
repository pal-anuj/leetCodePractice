// Last updated: 08/10/2026, 00:08:25
1class Solution {
2    public String freqAlphabets(String s) {
3        StringBuilder sb = new StringBuilder();
4        for (int i = 0; i < s.length(); i++) {
5            if(i+2 < s.length() && s.charAt(i+2) == '#'){
6                int num= (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
7                char c= (char)('a' + num - 1);
8                sb.append(c);
9                i+=2;
10            }
11            else{
12                int num= s.charAt(i)-'0';
13                char c= (char) ('a' + num -1);
14                sb.append(c);
15            }
16            
17        }
18        return sb.toString();
19    }
20}