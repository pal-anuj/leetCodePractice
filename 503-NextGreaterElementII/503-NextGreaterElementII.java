// Last updated: 10/01/2026, 12:59:10
1class Solution {
2    public int[] nextGreaterElements(int[] nums) {
3        int n=nums.length;
4        int[] res= new int[n];
5        Stack<Integer> st= new Stack<>();
6
7        for(int i=2*n-1; i>=0 ; i--){
8            int idx= i % n;
9            while(!st.isEmpty() && st.peek() <= nums[idx])
10                st.pop();
11
12            if(i<n){
13                int nge= st.isEmpty() ? -1 : st.peek();
14                res[idx]= nge;
15            }
16            st.push(nums[idx]);
17        }
18        return res;
19    }
20}