// Last updated: 25/06/2026, 09:57:30
1class Solution {
2    public int[] dailyTemperatures(int[] temp) {
3        int n = temp.length;
4        int[] res = new int[n];
5        Stack<Integer> st = new Stack<>();
6        for (int i = n - 1; i >= 0; i--) {
7            while (!st.isEmpty() && temp[st.peek()] <= temp[i]) {
8                st.pop();
9            }
10
11            if (st.isEmpty()) {
12                res[i] = 0;
13            } else {
14                // System.out.println("index="+i+" curtemp="+ temp[i] +", st peek="+ temp[st.peek()]);
15                res[i] = st.peek() - i;
16            }
17            st.push(i);
18        }
19
20        // // brute force
21        // for (int i = 0; i < n; i++) {
22        //     for (int j = i; j < n; j++) {
23        //         if (temp[i] < temp[j]) {
24        //             res[i] = j - i;
25        //             break;
26        //         }
27        //     }
28        // }
29        return res;
30    }
31}