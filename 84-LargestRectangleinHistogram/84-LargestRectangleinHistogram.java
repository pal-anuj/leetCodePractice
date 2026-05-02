// Last updated: 02/05/2026, 09:04:23
1class Solution {
2    public int largestRectangleArea(int[] heights) {
3        int n = heights.length;
4        int res = 0;
5        Stack<Integer> st = new Stack<>();
6        for (int i = 0; i < n; i++) {
7            int h = (i == n) ? 0 : heights[i];
8            while (!st.isEmpty() && h < heights[st.peek()]) {
9                int height = heights[st.pop()];
10                int right = i;
11                int left = st.isEmpty() ? 0 : st.peek() + 1;
12                res = Math.max(res, height * (right - left));
13            }
14            st.push(i);
15        }
16        // processing remaining element of stack
17        while (!st.isEmpty()) {
18            int tp = st.pop();
19            int curr = heights[tp] * (st.isEmpty() ? n : (n - st.peek() - 1)); //2-1-1
20            res = Math.max(res, curr);
21        }
22
23        // // Efficient Approach
24        // int[] ps= new int[n];
25        // for(int i=0;i<n;i++){
26        //     while(!st.isEmpty() && heights[st.peek()] >= heights[i])
27        //         st.pop();
28        //     ps[i]= st.isEmpty() ? -1 : st.peek();
29        //     st.push(i);    
30        // }
31
32        // while(!st.isEmpty()) st.pop();
33
34        // int[] ns= new int[n];
35        // for(int i=n-1;i>=0;i--){
36        //     while(!st.isEmpty() && heights[st.peek()] >= heights[i])
37        //         st.pop();
38        //     ns[i]= st.isEmpty() ? n: st.peek();
39        //     st.push(i);
40        // }
41
42        // for(int i=0;i<n;i++){
43        //     int cur= heights[i];
44        //     cur+= (i - ps[i] - 1 ) * heights[i];
45        //     cur+= (ns[i] - i - 1 ) * heights[i];
46        //     res= Math.max(res, cur); 
47        // }
48
49        // // Brute Force O(n2)
50        // for (int i = 0; i < n; i++) {
51        //     int cur=heights[i];
52        //     for(int j=i-1; j >= 0;j--){
53        //         if(heights[j]>= heights[i]) cur+= heights[i];
54        //         else break;
55        //     }
56        //     for(int j=i+1;j<n;j++){
57        //         if(heights[j]>= heights[i]) cur+= heights[i];
58        //         else break;
59        //     }
60        //     res= Math.max(res, cur);
61        // }
62
63        return res;
64    }
65}