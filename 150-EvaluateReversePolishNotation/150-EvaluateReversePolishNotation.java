// Last updated: 25/06/2026, 09:43:44
1class Solution {
2    public int evalRPN(String[] tokens) {
3        Stack<Integer> st = new Stack<>();
4        int sum = 1;
5        for (String token : tokens) {
6            if("+".equals(token) || "-".equals(token) || 
7                    "*".equals(token)|| "/".equals(token)){
8                    int b= st.pop();
9                    int a= st.pop();
10                    String ops= token;
11                    switch(ops) {
12                        case "+" -> st.push(a+b);
13                        case "-" -> st.push(a-b);
14                        case "*" -> st.push(a*b);
15                        case "/" -> st.push(a/b);
16                    }        
17            }
18            else{
19                int num = Integer.parseInt(token);
20                st.push(num);
21            }
22        }
23        return st.pop();
24    }
25}