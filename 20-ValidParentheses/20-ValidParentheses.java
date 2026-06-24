// Last updated: 24/06/2026, 08:58:05
1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> st = new Stack<>();
4        for (char c : s.toCharArray()) {
5            if (c == ')' || c == '}' || c == ']') {
6                if (!st.isEmpty() && ( (st.peek() == '(' && c==')')
7                    || (c==']' && st.peek()=='[') || (c=='}' && st.peek()=='{') )) {
8                    st.pop();
9                } 
10                else
11                    return false;
12            } 
13            else {
14                st.push(c);
15            }
16
17        }
18        return st.isEmpty();
19    }
20}