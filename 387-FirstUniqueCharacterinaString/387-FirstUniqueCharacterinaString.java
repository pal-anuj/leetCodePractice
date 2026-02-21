// Last updated: 22/02/2026, 00:03:35
1class Solution {
2    public int firstUniqChar(String s) {
3        int n = s.length();
4
5        Map<Character, Integer> map = new HashMap<>();
6
7        for (int i = 0; i < n; i++) {
8            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
9        }
10
11        for (int i = 0; i < n; i++) {
12            if (map.get(s.charAt(i)) == 1)
13                return i;
14        }
15        return -1;
16
17        /* // Brute force approach
18        for (int i = 0; i < n; i++) {
19            boolean repeated = false;
20            for (int j = 0; j < n; j++) {
21                if (s.charAt(i) == s.charAt(j) && i != j) {
22                    repeated = true;
23                    break;
24                }
25            }
26            if (repeated == false)
27                return i;
28        }
29        return -1;
30        */
31
32    }
33}