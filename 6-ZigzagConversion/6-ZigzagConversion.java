// Last updated: 18/06/2026, 09:58:37
1class Solution {
2    public String minWindow(String s, String t) {
3        int n = s.length();
4        int m = t.length();
5
6        if (n < m)
7            return "";
8
9        int[] hash = new int[256];
10        for (char c : t.toCharArray()) {
11            hash[c]++;
12        }
13
14        int minlen = Integer.MAX_VALUE;
15        int start = -1;
16        int cnt = 0;
17        int l = 0;
18        int r = 0;
19
20        while (r < n) {
21            if (hash[s.charAt(r)]-- > 0)
22                cnt++;
23
24            while (cnt == m) {
25                if (r - l + 1 < minlen) {
26                    minlen = r - l + 1;
27                    start = l;
28                }
29                hash[s.charAt(l)]++;
30                if (hash[s.charAt(l)] > 0)
31                    cnt--;
32                l++;
33            }
34            r++;
35        }
36
37        // //Brute force
38        // for (int i = 0; i < n; i++) {
39
40        //     int[] hash = new int[256];
41        //     for (int j = 0; j < m; j++) {
42        //         hash[t.charAt(j)]++;
43        //     }
44
45        //     int count = 0;
46        //     for (int j = i; j < n; j++) {
47        //         if (hash[s.charAt(j)] > 0)
48        //             count++;
49
50        //         hash[s.charAt(j)]--;
51
52        //         if (count == m) {
53        //             if (j - i + 1 < minlen) {
54        //                 minlen = j - i + 1;
55        //                 start = i;
56        //             }
57        //             System.out.println(minlen + ", start= " + i);
58        //             break;
59        //         }
60        //     }
61        //     System.out.println();
62        // }
63        return start == -1 ? "" : s.substring(start, start + minlen);
64    }
65}