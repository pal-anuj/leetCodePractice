// Last updated: 30/04/2026, 08:56:15
1class Solution {
2    public int[] dailyTemperatures(int[] temp) {
3        int n = temp.length;
4        int[] res = new int[n];
5        Stack<Integer> st = new Stack<>();
6        for (int i = n - 1; i >= 0; i--) {
7            while (!st.isEmpty() && temp[i] >= temp[st.peek()]) {
8                st.pop();
9            }
10
11            res[i] = st.isEmpty() ? 0 : st.peek() - i;
12            st.push(i);
13        }
14
15        // // brute force
16        // for (int i = 0; i < n; i++) {
17        //     for (int j = i; j < n; j++) {
18        //         if (temp[i] < temp[j]) {
19        //             res[i] = j - i;
20        //             break;
21        //         }
22        //     }
23        // }
24        return res;
25    }
26}