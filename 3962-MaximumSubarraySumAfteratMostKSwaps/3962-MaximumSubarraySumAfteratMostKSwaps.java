// Last updated: 16/06/2026, 23:13:18
1class Solution {
2    public int characterReplacement(String s, int k) {
3        int n = s.length();
4        int res = 0;
5        int l = 0;
6        int r = 0;
7        int maxlen = 0;
8        int maxf = 0;
9
10        int[] freq = new int[26];
11        while (r < s.length()) {
12            char ch = s.charAt(r);
13            freq[ch - 'A']++;
14            maxf = Math.max(maxf, freq[ch - 'A']);
15
16            if ((r - l + 1) - maxf > k) {
17                freq[s.charAt(l) - 'A']--;
18                maxf = 0;
19                // for (int i = 0; i < 26; i++) {
20                    // maxf = Math.max(maxf, freq[i]);
21                // }
22                l++;
23            }
24
25            if ((r - l + 1) - maxf <= k)
26                maxlen = Math.max(maxlen, r - l + 1);
27
28            r++;
29        }
30        return maxlen;
31
32        // // Brute force approach
33        // for (int i = 0; i < n; i++) {
34        //     int[] freq = new int[26];
35        //     int maxfreq= 0;
36        //     for (int j = i; j < n; j++) {
37
38        //         char ch = s.charAt(j);
39        //         freq[ch - 'A']++;
40
41        //         maxfreq = Math.max(maxfreq, freq[ch-'A']);
42
43        //         int len = j - i + 1;
44        //         if (len - maxfreq <= k) {
45        //             res = Math.max(res, len);
46        //         }
47        //     }
48        // }
49        // return res;
50    }
51}