// Last updated: 09/01/2026, 01:03:15
1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3
4        int n1= nums1.length;
5        int n2= nums2.length;
6        int[] res= new int[n1];  
7        Map<Integer, Integer> nge= new HashMap<>();      
8        Stack<Integer> st= new Stack<Integer>();
9        
10        st.push(nums2[n2-1]);
11        nge.put(nums2[n2-1], -1);
12        for(int i=n2-1; i>=0; i--){
13            while(!st.isEmpty() && st.peek()<= nums2[i])
14                st.pop();
15
16            int ng= st.isEmpty() ? -1: st.peek();
17            nge.put(nums2[i], ng);   
18            st.push(nums2[i]);
19        }
20
21        for(int i=0;i<n1;i++){
22            res[i]= nge.get(nums1[i]);
23        }
24        return res;
25    }
26}