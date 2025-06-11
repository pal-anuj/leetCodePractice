// Last updated: 11/06/2025, 17:43:58
import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
       Stack<Character> charStack = new Stack<>();
		char[] ch = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			char ab = ch[i];
			if (ab == '(' || ab == '[' || ab == '{') {
				// push element in stack
				charStack.push(ab);
				continue;
			}
			if (charStack.isEmpty())
				return false;

			char check;
			switch (ab) {
			case ')':
				check = charStack.pop();
				if (check == '[' || check == '{')
					return false;
				break;
			case ']':
				check = charStack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			case '}':
				check = charStack.pop();
				if (check == '(' || check == '[')
					return false;
				break;
			}

		}
		return charStack.isEmpty();
		}
}