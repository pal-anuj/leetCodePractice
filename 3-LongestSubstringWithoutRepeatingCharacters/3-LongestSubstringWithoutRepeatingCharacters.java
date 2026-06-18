// Last updated: 18/06/2026, 23:24:45
1class Solution {
2    public int longestSubstring(String s, int k) {
3        if (s.length() < k)
4            return 0;
5
6        int[] freq = new int[26];
7        for (int i = 0; i < s.length(); i++) {
8            freq[s.charAt(i) - 'a']++;
9        }
10
11        for (int i = 0; i < s.length(); i++) {
12            if (freq[s.charAt(i) - 'a'] < k) {
13                return Math.max(longestSubstring(s.substring(0, i), k),
14                        longestSubstring(s.substring(i + 1, s.length()), k));
15            }
16        }
17
18        return s.length();
19        // // Brute force
20        // for (int i = 0; i < s.length(); i++) {
21        //     int[] freq = new int[26];
22        //     for (int j = i; j < s.length(); j++) {
23        //         freq[s.charAt(j) - 'a']++;
24        //         boolean valid = true;
25        //         for (int c : freq) {
26        //             if (c > 0 && c < k) {
27        //                 valid = false;
28        //                 break;
29        //             }
30        //         }
31
32        //         if (valid) {
33        //             maxlen = Math.max(maxlen, j - i + 1);
34        //         }
35        //     }
36        // }
37        // return maxlen;
38    }
39}