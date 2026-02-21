// Last updated: 22/02/2026, 00:07:29
1class Solution {
2    public int firstUniqChar(String s) {
3        int n = s.length();
4
5        // optimized Approach
6        int[] arr = new int[26];
7        Arrays.fill(arr, 0);
8        for (int i = 0; i < n; i++) {
9            arr[s.charAt(i) - 'a']++;
10        }
11
12        for (int i = 0; i < n; i++) {
13            if (arr[s.charAt(i) - 'a'] == 1)
14                return i;
15        }
16        return -1;
17
18        /*
19        // Efficient Approach
20        Map<Character, Integer> map = new HashMap<>();
21        
22        for (int i = 0; i < n; i++) {
23            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
24        }
25        
26        for (int i = 0; i < n; i++) {
27            if (map.get(s.charAt(i)) == 1)
28                return i;
29        }
30        return -1;
31        */
32
33        /* // Brute force approach
34        for (int i = 0; i < n; i++) {
35            boolean repeated = false;
36            for (int j = 0; j < n; j++) {
37                if (s.charAt(i) == s.charAt(j) && i != j) {
38                    repeated = true;
39                    break;
40                }
41            }
42            if (repeated == false)
43                return i;
44        }
45        return -1;
46        */
47
48    }
49}