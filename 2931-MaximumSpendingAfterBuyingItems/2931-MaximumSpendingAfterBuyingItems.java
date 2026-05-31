// Last updated: 01/06/2026, 00:12:42
1class Solution {
2    public int evalRPN(String[] tokens) {
3        Stack<Integer> st = new Stack<>();
4        int sum = 1;
5        for (String token : tokens) {
6            if ("+".equals(token) || "-".equals(token) || "*".equals(token)
7                    || "/".equals(token)) {
8
9                int b = st.pop();
10                int a = st.pop();
11                String ops = token;
12                switch (ops) {
13                    case "+":
14                        st.push(a + b);
15                        break;
16                    case "-":
17                        st.push(a - b);
18                        break;
19                    case "*":
20                        st.push(a * b);
21                        break;
22                    case "/":
23                        st.push(a / b);
24                        break;
25                }
26            } else {
27                int num = Integer.parseInt(token);
28                st.push(num);
29            }
30        }
31        return st.pop();
32    }
33}