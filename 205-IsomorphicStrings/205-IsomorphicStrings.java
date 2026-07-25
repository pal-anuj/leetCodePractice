// Last updated: 25/07/2026, 12:59:52
1class Solution {
2    public boolean isIsomorphic(String s, String t) {
3        Map<Character, Character> sToT = new HashMap<>();
4        Map<Character, Character> tToS = new HashMap<>();
5        for (int i = 0; i < s.length(); i++) {
6            char a = s.charAt(i);
7            char b = t.charAt(i);
8
9            Character x = sToT.get(a);
10            Character y = tToS.get(b);
11
12            if (x != null && x != b)
13                return false;
14
15            if (y != null && y != a)
16                return false;
17                
18            sToT.put(a, b);
19            tToS.put(b, a);
20
21        }
22        return true;
23    }
24}