// Last updated: 03/04/2026, 23:59:18
1class Solution {
2    public int[] asteroidCollision(int[] asteroids) {
3        int n = asteroids.length;
4        Stack<Integer> st = new Stack<>();
5        for (int i = 0; i < n; i++) {
6            int a = asteroids[i];
7            if (a > 0) {
8                st.push(a);
9            } else {
10                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(a)) {
11                    st.pop(); // stack asteroid destroyed
12                }
13
14                // equal size → both destroyed
15                if (!st.isEmpty() && st.peek() == Math.abs(a)) {
16                    st.pop();
17                }
18                // push only if no collision OR left-moving stack
19                else if (st.isEmpty() || st.peek() < 0)
20                    st.push(a);
21                // else: current asteroid destroyed → do nothing
22            }
23        }
24
25        // convert stack to array
26        int[] result = new int[st.size()];
27        for (int i = result.length - 1; i >= 0; i--) {
28            result[i] = st.pop();
29        }
30
31        return result;
32    }
33}