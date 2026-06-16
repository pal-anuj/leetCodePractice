// Last updated: 16/06/2026, 23:12:52
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
16            while ((r - l + 1) - maxf > k) {
17                freq[s.charAt(l) - 'A']--;
18                maxf = 0;
19                for (int i = 0; i < 26; i++) {
20                    maxf = Math.max(maxf, freq[i]);
21                }
22                System.out.println("Anuj=" + l);
23                l++;
24            }
25
26            if ((r - l + 1) - maxf <= k)
27                maxlen = Math.max(maxlen, r - l + 1);
28
29            r++;
30        }
31        return maxlen;
32
33        // // Brute force approach
34        // for (int i = 0; i < n; i++) {
35        //     int[] freq = new int[26];
36        //     int maxfreq= 0;
37        //     for (int j = i; j < n; j++) {
38
39        //         char ch = s.charAt(j);
40        //         freq[ch - 'A']++;
41
42        //         maxfreq = Math.max(maxfreq, freq[ch-'A']);
43
44        //         int len = j - i + 1;
45        //         if (len - maxfreq <= k) {
46        //             res = Math.max(res, len);
47        //         }
48        //     }
49        // }
50        // return res;
51    }
52}