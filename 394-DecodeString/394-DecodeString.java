// Last updated: 22/08/2026, 20:12:22
1class Solution {
2    public String decodeString(String s) {
3        // 3,a,2,c
4        // 3acc
5        // 3a2bc
6        // 2[abc]3[cd]ef
7        // 2abc 3cd 1ef
8        Stack<Integer> st1 = new Stack<>();
9        Stack<String> st2 = new Stack<>();
10
11        int n = s.length();
12        int i = 0;
13
14        while (i < n) {
15
16            char c = s.charAt(i);
17
18            // number
19            if (Character.isDigit(c)) {
20                int num = 0;
21                while (i < s.length() && Character.isDigit(s.charAt(i))) {
22                    num = num * 10 + (s.charAt(i) - '0');
23                    i++;
24                }
25                st1.push(num);
26                continue;
27            }
28
29            // Opening bracket or character
30            if (c != ']') {
31                st2.push(String.valueOf(c));
32            } else {
33
34                // Build string inside []    
35                String str = "";
36                while (!st2.isEmpty() && !st2.peek().equals("[")) {
37                    str = st2.pop() + str;
38                }
39
40                // Remove "["
41                st2.pop();
42
43                // Get repeat count
44                int repeat = st1.pop();
45
46                // Repeat
47                String res = "";
48                for (int j = 0; j < repeat; j++) {
49                    res += str;
50                }
51                st2.push(res);
52            }
53            i++;
54        }
55
56        // Build final answer
57        String result = "";
58        while (!st2.isEmpty()) {
59            result = st2.pop() + result;
60        }
61        return result;
62    }
63}
64