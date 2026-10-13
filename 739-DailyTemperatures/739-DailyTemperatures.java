// Last updated: 13/10/2026, 12:14:46
1class Solution {
2    public int[] dailyTemperatures(int[] temperatures) {
3        int n = temperatures.length;
4        int[] res = new int[n];
5
6        Stack<Integer> st= new Stack<>();
7        st.push(n-1);
8        res[n-1]=0;
9        for(int i=n-2;i>=0;i--){
10            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
11                st.pop();
12            }
13            res[i]= !st.isEmpty() ? st.peek() - i : 0;
14            st.push(i);
15        }
16
17
18        // for (int i = 0; i < n; i++) {
19        //     int count = 0;
20        //     int j = i;
21        //     boolean warmerDayFound = false;
22        //     for (j = i + 1; j < n; j++) {
23        //         if (temperatures[j] > temperatures[i]) {
24        //             warmerDayFound = true;
25        //             break;
26        //         }
27        //     }
28        //     res[i] = warmerDayFound ? j - i : 0;
29        // }
30        return res;
31    }
32}