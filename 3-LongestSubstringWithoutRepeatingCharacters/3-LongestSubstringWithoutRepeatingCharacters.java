// Last updated: 21/03/2026, 22:23:31
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int maxL = 0;
4
5        // Efficient Approach
6        int left = 0;
7        HashMap<Character, Integer> lastSeenIndex = new HashMap<>();
8
9        for (int i = 0; i < s.length(); i++) {
10            char curChar = s.charAt(i);
11            if (lastSeenIndex.containsKey(curChar)) {
12                left = Math.max(left, lastSeenIndex.get(curChar) + 1);
13            }
14            int curWin= i - left + 1;
15            maxL = Math.max(maxL, curWin);
16            lastSeenIndex.put(curChar, i);
17        }
18
19        // // Brute Force O(n2)
20        // for (int i = 0; i < s.length(); i++) {
21        //     HashSet<Character> hs = new HashSet<>();
22        //     for (int j = i; j < s.length(); j++) {
23        //         if (hs.contains(s.charAt(j)))
24        //             break;
25
26        //         maxL = Math.max(maxL, j - i + 1);
27        //         hs.add(s.charAt(j));
28        //     }
29        // }
30        return maxL;
31    }
32}