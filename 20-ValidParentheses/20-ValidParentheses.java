// Last updated: 29/07/2026, 07:29:45
1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> st = new Stack<>();
4
5        for(char ch : s.toCharArray()){
6            if(ch =='(')
7                st.push(')');
8            else if(ch=='{')
9                st.push('}');
10            else if(ch=='[')
11                st.push(']');
12            else if(!st.isEmpty() && ch == st.peek())
13                st.pop();    
14            else return false;
15        }
16        return st.isEmpty()? true: false;
17    }
18}