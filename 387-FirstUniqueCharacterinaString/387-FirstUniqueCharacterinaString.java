// Last updated: 22/02/2026, 00:11:30
1class Solution {
2    public int firstUniqChar(String s) {
3        int n = s.length();
4
5        // optimized Approach
6        // Frequency array for 26 lowercase letters
7        int[] charfreq = new int[26];
8
9        // Count frequency of each character 
10        for (int i = 0; i < n; i++) {
11            char currentChar = s.charAt(i);
12            charfreq[currentChar - 'a']++;
13        }
14
15        // Find first character with frequency 1
16        for (int i = 0; i < n; i++) {
17            char currentChar = s.charAt(i);
18            if (charfreq[currentChar - 'a'] == 1)
19                return i;
20        }
21        return -1;
22
23        /*
24        // Efficient Approach
25        Map<Character, Integer> map = new HashMap<>();
26        
27        for (int i = 0; i < n; i++) {
28            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
29        }
30        
31        for (int i = 0; i < n; i++) {
32            if (map.get(s.charAt(i)) == 1)
33                return i;
34        }
35        return -1;
36        */
37
38        /* // Brute force approach
39        for (int i = 0; i < n; i++) {
40            boolean repeated = false;
41            for (int j = 0; j < n; j++) {
42                if (s.charAt(i) == s.charAt(j) && i != j) {
43                    repeated = true;
44                    break;
45                }
46            }
47            if (repeated == false)
48                return i;
49        }
50        return -1;
51        */
52
53    }
54}