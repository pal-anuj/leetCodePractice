// Last updated: 14/10/2026, 00:54:55
1class Solution {
2    public String removeKdigits(String num, int k) {
3        int n = num.length();
4        Stack<Character> st = new Stack<>();
5        for (int i = 0; i < n; i++) {
6            char c = num.charAt(i);
7            while (!st.isEmpty() && k > 0 && st.peek() > c) {
8                st.pop();
9                k--;
10            }
11            st.push(c);
12        }
13
14        while (k > 0) {
15            st.pop();
16            k--;
17        }
18
19        StringBuilder res = new StringBuilder();
20        for (char digit : st) {
21            if (res.length() > 0 || digit != '0')
22                res.append(digit);
23        }
24
25        return res.length() == 0 ? "0" : res.toString();
26    }
27}