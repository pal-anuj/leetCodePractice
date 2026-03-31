// Last updated: 31/03/2026, 20:57:05
1class Solution {
2    public int[] dailyTemperatures(int[] temp) {
3        int n = temp.length;
4        int[] res = new int[n];
5        Stack<Integer> st = new Stack<>();
6        for (int i = 0; i < n; i++) {
7
8            while (!st.isEmpty() && temp[st.peek()] < temp[i]) {
9                int idx = st.pop();
10                res[idx] = i - idx;
11            }
12            st.push(i);
13        }
14        return res;
15    }
16}