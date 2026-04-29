// Last updated: 29/04/2026, 23:10:32
1import java.util.Stack;
2class Solution {
3    public boolean isValid(String s) {
4       Stack<Character> charStack = new Stack<>();
5		char[] ch = s.toCharArray();
6
7		for (int i = 0; i < s.length(); i++) {
8			char ab = ch[i];
9			if (ab == '(' || ab == '[' || ab == '{') {
10				// push element in stack
11				charStack.push(ab);
12				continue;
13			}
14			if (charStack.isEmpty())
15				return false;
16
17			char check;
18			switch (ab) {
19			case ')':
20				check = charStack.pop();
21				if (check == '[' || check == '{')
22					return false;
23				break;
24			case ']':
25				check = charStack.pop();
26				if (check == '(' || check == '{')
27					return false;
28				break;
29			case '}':
30				check = charStack.pop();
31				if (check == '(' || check == '[')
32					return false;
33				break;
34			}
35
36		}
37		return charStack.isEmpty();
38		}
39}