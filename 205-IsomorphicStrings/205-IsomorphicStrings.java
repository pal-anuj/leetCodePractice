// Last updated: 25/07/2026, 12:54:07
1class Solution {
2    public boolean isIsomorphic(String s, String t) {
3        Map<Character, Character> sToT = new HashMap<>();
4        Map<Character, Character> tToS = new HashMap<>();
5        for (int i = 0; i < s.length(); i++) {
6            char a = s.charAt(i);
7            char b = t.charAt(i);
8            if (sToT.containsKey(a)) {
9                if (sToT.get(a) != b)
10                    return false;
11            }
12            if (tToS.containsKey(b)) {
13                if (tToS.get(b) != a)
14                    return false;
15            }
16            sToT.put(a, b);
17            tToS.put(b, a);
18
19        }
20        return true;
21    }
22}