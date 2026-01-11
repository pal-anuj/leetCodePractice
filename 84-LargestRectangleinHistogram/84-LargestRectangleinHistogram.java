// Last updated: 11/01/2026, 11:14:11
1class Solution {
2    public int largestRectangleArea(int[] heights) {
3    // Total number of bars
4    int n = heights.length;
5
6    // Variable to store the maximum area found
7    int res = 0;
8
9    // Stack to store indices of bars
10    Stack<Integer> st = new Stack<>();
11
12    // ps[i] → index of Previous Smaller Element for heights[i]
13    int[] ps = new int[n];
14
15    // ns[i] → index of Next Smaller Element for heights[i]
16    int[] ns = new int[n];
17
18
19    // ----------- Find Previous Smaller Element (PSE) -----------
20
21    // Traverse from left to right
22    for (int i = 0; i < n; i++) {
23
24        // Remove bars from stack that are
25        // taller or equal to current bar
26        while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
27            st.pop();
28        }
29
30        // If stack is empty, no smaller element on left
31        // else top of stack is previous smaller element
32        ps[i] = st.isEmpty() ? -1 : st.peek();
33
34        // Push current index to stack
35        st.push(i);
36    }
37
38
39    // Clear stack before next operation
40    while (!st.isEmpty()) {
41        st.pop();
42    }
43
44
45    // ----------- Find Next Smaller Element (NSE) -----------
46
47    // Traverse from right to left
48    for (int i = n - 1; i >= 0; i--) {
49
50        // Remove bars from stack that are
51        // taller or equal to current bar
52        while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
53            st.pop();
54        }
55
56        // If stack is empty, no smaller element on right
57        // else top of stack is next smaller element
58        ns[i] = st.isEmpty() ? n : st.peek();
59
60        // Push current index to stack
61        st.push(i);
62    }
63
64
65    // ----------- Calculate Maximum Rectangle Area -----------
66
67    for (int i = 0; i < n; i++) {
68
69        // Height of current bar
70        int curr = heights[i];
71
72        // Width = distance between next smaller and previous smaller
73        // Left width  = i - ps[i] - 1
74        // Right width = ns[i] - i - 1
75        curr += (i - ps[i] - 1) * heights[i];
76        curr += (ns[i] - i - 1) * heights[i];
77
78        // Update maximum area
79        res = Math.max(res, curr);
80    }
81
82
83    /* brute force approach
84
85    // Iterate through each bar considering it as the minimum height
86    for (int i = 0; i < n; i++) {
87
88        // Start with the height of the current bar
89        int curr = heights[i];
90
91        // Expand to the LEFT of the current bar
92        for (int j = i - 1; j >= 0; j--) {
93
94            // If left bar height is >= current bar,
95            // we can extend the rectangle
96            if (heights[j] >= heights[i]) {
97                curr += heights[i]; // add current height to area
98            } else {
99                // Stop expansion when a smaller bar is found
100                break;
101            }
102        }
103
104        // Expand to the RIGHT of the current bar
105        for (int j = i + 1; j < n; j++) {
106
107            // If right bar height is >= current bar,
108            // extend the rectangle
109            if (heights[j] >= heights[i]) {
110                curr += heights[i]; // add current height to area
111            } else {
112                // Stop expansion when a smaller bar is found
113                break;
114            }
115        }
116
117        // Update maximum area found so far
118        res = Math.max(res, curr);
119    }
120    */
121
122    // Return the largest rectangle area
123    return res;
124
125    }
126}