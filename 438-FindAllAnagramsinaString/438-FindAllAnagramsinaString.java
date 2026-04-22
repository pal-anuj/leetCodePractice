// Last updated: 22/04/2026, 06:50:57
1class Solution {
2    public List<Integer> findAnagrams(String s, String p) {
3        int m = p.length();
4        int n = s.length();
5
6        int[] arr = new int[26];
7        for (int i = 0; i < m; i++)
8            arr[p.charAt(i) - 'a']++;
9
10        List<Integer> ls = new ArrayList<>();
11        for (int i = 0; i <= n - m; i++) {
12            int[] temp = new int[26];
13            for (int j = i; j < i + m  && j < n; j++) {
14                temp[s.charAt(j) - 'a']++;
15            }
16
17            int k;
18            for (k = 0; k < 26; k++) {
19                if (arr[k] != temp[k])
20                    break;
21            }
22            if (k == 26)
23                ls.add(i);
24        }
25        return ls;
26    }
27}