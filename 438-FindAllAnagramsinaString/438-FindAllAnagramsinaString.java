// Last updated: 24/04/2026, 07:55:19
1class Solution {
2    public String minWindow(String s, String t) {
3        int n = s.length();
4        int m = t.length();
5
6        if (m > n)
7            return "";
8
9        int[] freq = new int[256];
10        for (char c : t.toCharArray()) {
11            freq[c]++;
12        }
13
14        // Efficeint Approach Time Comeplexity: O(2n+m), Space Complexity: O(256)
15        int l = 0;
16        int r = 0;
17        int count = 0;
18        int minLen = Integer.MAX_VALUE;
19        int startIdx = -1;
20        while (r < n) {
21            if (freq[s.charAt(r)] > 0) {
22                count++;
23            }
24            freq[s.charAt(r)]--;
25
26            while (count == m) {
27                if (r - l + 1 < minLen) {
28                    minLen = r - l + 1;
29                    startIdx = l;
30                }
31
32                freq[s.charAt(l)]++;
33                if (freq[s.charAt(l)] > 0)
34                    count = count - 1;
35                l++;
36            }
37            r = r + 1;
38        }
39        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
40
41        // // Brute Force O(n2)
42        // int startIdx = 0;
43        // int endIdx = n;
44        // boolean stringFound = false;
45        // for (int i = 0; i <= n - m; i++) {
46        //     int count = m;
47        //     int[] temp = freq.clone();
48        //     for (int j = i; j < n; j++) {
49        //         if (temp[s.charAt(j)]-- > 0)
50        //             count--;
51        //         if (count == 0) {
52        //             if (endIdx - startIdx > j - i) {
53        //                 startIdx = i;
54        //                 endIdx = j + 1;
55        //             }
56        //             stringFound = true;
57        //             break;
58        //         }
59        //     }
60        // }
61        // return stringFound ? s.substring(startIdx, endIdx) : "";
62    }
63}