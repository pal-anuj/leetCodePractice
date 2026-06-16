// Last updated: 16/06/2026, 23:13:57
1class Solution {
2    public int characterReplacement(String s, int k) {
3        int l = 0;
4        int r = 0;
5        int maxlen = 0;
6        int maxf = 0;
7
8        int[] freq = new int[26];
9        while (r < s.length()) {
10            char ch = s.charAt(r);
11            freq[ch - 'A']++;
12            maxf = Math.max(maxf, freq[ch - 'A']);
13
14            if ((r - l + 1) - maxf > k) {
15                freq[s.charAt(l) - 'A']--;
16                maxf = 0;
17                // for (int i = 0; i < 26; i++) {
18                    // maxf = Math.max(maxf, freq[i]);
19                // }
20                l++;
21            }
22
23            if ((r - l + 1) - maxf <= k)
24                maxlen = Math.max(maxlen, r - l + 1);
25
26            r++;
27        }
28        return maxlen;
29
30        // // Brute force approach
31        // for (int i = 0; i < n; i++) {
32        //     int[] freq = new int[26];
33        //     int maxfreq= 0;
34        //     for (int j = i; j < n; j++) {
35
36        //         char ch = s.charAt(j);
37        //         freq[ch - 'A']++;
38
39        //         maxfreq = Math.max(maxfreq, freq[ch-'A']);
40
41        //         int len = j - i + 1;
42        //         if (len - maxfreq <= k) {
43        //             res = Math.max(res, len);
44        //         }
45        //     }
46        // }
47        // return res;
48    }
49}