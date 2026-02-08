// Last updated: 08/02/2026, 15:41:51
class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();
        for(int ele: nums){
            long num = ele;
            while(!st.isEmpty() && st.peek() == num){
                st.pop();
                num += num;
            }
            st.push(num);
        }
        List<Long> ans = new ArrayList<>();
        for(int i=0; i<st.size(); i++){
            ans.add(st.get(i));
        }
        return ans;
    }
}