// Last updated: 14/09/2026, 18:10:12
1class Solution {
2    public void reverseString(char[] s) {
3        int l = 0;
4        int r = s.length - 1;
5        while (l < r) {
6            swap(s, l, r);
7            l++;
8            r--;
9        }
10    }
11
12    private void swap(char[] s, int l, int r) {
13        char temp = s[l];
14        s[l] = s[r];
15        s[r] = temp;
16    }
17}