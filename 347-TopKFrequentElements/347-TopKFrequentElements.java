// Last updated: 29/04/2026, 23:13:29
1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> st = new Stack<>();
4        for (int i = 0; i < s.length(); i++) {
5            char ch = s.charAt(i);
6            if (ch == '(')
7                st.push(')');
8            else if (ch == '{')
9                st.push('}');
10            else if (ch == '[')
11                st.push(']');
12            else {
13                if (st.isEmpty() || st.pop() != ch)
14                    return false;
15            }
16        }
17        return st.isEmpty();
18    }
19}