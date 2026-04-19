// Last updated: 19/04/2026, 22:23:03
1class Solution {
2    public boolean checkInclusion(String s1, String s2) {
3        int n = s1.length();
4        int m = s2.length();
5        System.out.println("n:" + n);
6        System.out.println("m:" + m);
7
8        int[] freqCount = new int[26];
9        for (int i = 0; i < n; i++) {
10            freqCount[s1.charAt(i) - 'a']++;
11        }
12
13        for (int i = 0; i <= m - n; i++) {
14            int[] copy = freqCount.clone();
15            for (int j = i; j < (i + n) && (j < m); j++) {
16                copy[s2.charAt(j) - 'a']--;
17            }
18            int k;
19            for (k = 0; k < 26; k++) {
20                if (copy[k] == 0)
21                    continue;
22                else
23                    break;
24            }
25            if (k == 26)
26                return true;
27        }
28        return false;
29    }
30}