// Last updated: 24/06/2026, 09:01:43
1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> st = new Stack<>();
4        for (char c : s.toCharArray()) {
5            if (c == '(')
6                st.push(')');
7            else if (c == '[')
8                st.push(']');
9            else if (c == '{')
10                st.push('}');
11            else {
12                if (st.isEmpty() || st.pop() != c)
13                    return false;
14            }
15        }
16        return st.isEmpty();
17    }
18}