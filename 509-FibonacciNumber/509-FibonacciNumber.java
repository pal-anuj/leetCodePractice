// Last updated: 14/09/2026, 18:14:07
1class Solution {
2    public void reverseString(char[] s) {
3        int l = 0;
4        int r = s.length - 1;
5        reverse(s, l, r);
6        // while (l < r) {
7        //     swap(s, l, r);
8        //     l++;
9        //     r--;
10        // }
11    }
12
13    private void reverse(char[] s, int l, int r) {
14        if (l >= r)
15            return;
16
17        char temp = s[l];
18        s[l] = s[r];
19        s[r] = temp;
20        l++;
21        r--;
22
23        reverse(s, l, r);
24    }
25
26    private void swap(char[] s, int l, int r) {
27        char temp = s[l];
28        s[l] = s[r];
29        s[r] = temp;
30    }
31}