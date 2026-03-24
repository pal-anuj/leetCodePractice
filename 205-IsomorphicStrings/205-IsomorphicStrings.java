// Last updated: 24/03/2026, 23:37:42
1class Solution {
2    public boolean isIsomorphic(String s, String t) {
3        HashMap<Character, Character> map = new HashMap<>();
4
5        for (int i = 0; i < s.length(); i++) {
6            Character a = s.charAt(i);
7            Character b = t.charAt(i);
8
9            if (map.containsKey(a)) {
10                if (b != map.get(a))
11                    return false;
12            } else if (map.containsValue(b))
13                return false;
14            map.put(a, b);
15        }
16        return true;
17    }
18
19}