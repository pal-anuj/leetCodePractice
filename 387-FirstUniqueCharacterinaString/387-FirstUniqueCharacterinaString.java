// Last updated: 21/02/2026, 23:58:58
1class Solution {
2    public int firstUniqChar(String s) {
3        int n = s.length();
4        for (int i = 0; i < n; i++) {
5            boolean repeated = false;
6            for (int j = 0; j < n; j++) {
7                if (s.charAt(i) == s.charAt(j) && i != j) {
8                    repeated = true;
9                    break;
10                }
11            }
12            if (repeated == false)
13                return i;
14        }
15        return -1;
16    }
17}