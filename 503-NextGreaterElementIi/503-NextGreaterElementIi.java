// Last updated: 24/01/2026, 00:09:49
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res= new int[n];
        Stack<Integer> st= new Stack<>();

        for(int i=2*n-1; i>=0 ; i--){
            int idx= i % n;
            while(!st.isEmpty() && st.peek() <= nums[idx])
                st.pop();

            if(i<n){
                int nge= st.isEmpty() ? -1 : st.peek();
                res[idx]= nge;
            }
            st.push(nums[idx]);
        }
        return res;
    }
}