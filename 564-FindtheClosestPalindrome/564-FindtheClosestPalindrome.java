// Last updated: 05/09/2026, 12:47:22
1class Solution {
2    // Any closest palindrome must come from one of these 5 candidates:
3    // 1. 10^(len-1) - 1
4    // 2. 10^len + 1
5    // 3. Palindrome made by mirroring the prefix
6    // 4. Palindrome made by mirroring prefix - 1
7    // 5. Palindrome made by mirroring prefix + 1
8    public String nearestPalindromic(String n) {
9        long num = Long.parseLong(n);
10        int len = n.length();
11
12        Set<Long> candidates = new HashSet<>();
13        candidates.add((long) Math.pow(10, len - 1) - 1);
14        candidates.add((long) Math.pow(10, len) + 1);
15
16        int prefixlen = (len + 1) / 2;
17
18        long prefix = Long.parseLong(n.substring(0, prefixlen));
19        candidates.add(makePalindrom(prefix, len));
20        candidates.add(makePalindrom(prefix - 1, len));
21        candidates.add(makePalindrom(prefix + 1, len));
22
23        long res = -1;
24        for (long candidate : candidates) {
25
26            if (candidate == num) {
27                continue;
28            }
29            long dif = Math.abs(num - candidate);
30            if (res == -1 || dif < Math.abs(num - res) || (dif == Math.abs(num - res) && candidate < res)) {
31                res = candidate;
32            }
33        }
34        System.out.println(candidates);
35        return String.valueOf(res);
36
37    }
38
39    private long makePalindrom(long prefix, int len) {
40        String left = String.valueOf(prefix);
41
42        int st = len % 2 == 0 ? left.length() - 1 : left.length() - 2;
43        StringBuilder sb = new StringBuilder(left);
44
45        for (int i = st; i >= 0; i--) {
46            sb.append(left.charAt(i));
47        }
48        return Long.parseLong(sb.toString());
49    }
50}