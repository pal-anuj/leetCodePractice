// Last updated: 25/06/2026, 09:41:54
1class Solution {
2    public int evalRPN(String[] tokens) {
3        Stack<Integer> st = new Stack<>();
4        int sum = 1;
5        for (String token : tokens) {
6            if("+".equals(token) || "-".equals(token) || 
7                    "*".equals(token)|| "/".equals(token)){
8                    int b= st.pop();
9                    int a= st.pop();
10                    String exp= token;
11                    switch(exp) {
12                        case "+" :
13                            st.push(a+b);
14                            break;
15                        
16                        case("-"):
17                            st.push(a-b);
18                            break;
19                        case("*"):
20                            st.push(a*b);
21                            break;
22                        case("/"):
23                            st.push(a/b);
24                            break;
25                    }        
26            }
27            else{
28                int num = Integer.parseInt(token);
29                st.push(num);
30            }
31        }
32        return st.pop();
33    }
34}