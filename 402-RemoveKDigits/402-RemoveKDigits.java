// Last updated: 01/05/2026, 17:56:35
1class Solution {
2    public int largestRectangleArea(int[] heights) {
3        int n = heights.length;
4        int res=0;
5        Stack<Integer> st= new Stack<>();        
6        int[] ps= new int[n];
7        for(int i=0;i<n;i++){
8            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
9                st.pop();
10            ps[i]= st.isEmpty() ? -1 : st.peek();
11            st.push(i);    
12        }
13        
14        while(!st.isEmpty()) st.pop();
15
16        int[] ns= new int[n];
17        for(int i=n-1;i>=0;i--){
18            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
19                st.pop();
20            ns[i]= st.isEmpty() ? n: st.peek();
21            st.push(i);
22        }
23
24        for(int i=0;i<n;i++){
25            int cur= heights[i];
26            cur+= (i - ps[i] - 1 ) * heights[i];
27            cur+= (ns[i] - i - 1 ) * heights[i];
28            res= Math.max(res, cur); 
29        }
30
31        // // Brute Force O(n2)
32        // for (int i = 0; i < n; i++) {
33        //     int cur=heights[i];
34        //     for(int j=i-1; j >= 0;j--){
35        //         if(heights[j]>= heights[i]) cur+= heights[i];
36        //         else break;
37        //     }
38        //     for(int j=i+1;j<n;j++){
39        //         if(heights[j]>= heights[i]) cur+= heights[i];
40        //         else break;
41        //     }
42        //     res= Math.max(res, cur);
43        // }
44
45        return res;
46    }
47}