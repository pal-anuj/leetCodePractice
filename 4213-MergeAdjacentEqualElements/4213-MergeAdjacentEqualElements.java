// Last updated: 16/04/2026, 05:36:31
class Solution {
    //[4,1,1,2]
    public List<Long> mergeAdjacent(int[] nums) {

        Stack<Long> st = new Stack<>();

        for (int ele : nums) {
            long num = ele;
            while (!st.isEmpty() && st.peek() == num) {
                st.pop();
                num += num;
            }
            st.push(num);
        }
        List<Long> ans = new ArrayList<>();
        for (int i = 0; i < st.size(); i++) {
            ans.add(st.get(i));
        }
        return ans;

        // for (int i = 0; i < nums.length; i++) {

        //     st.push((long) nums[i]);
        //     while (st.size() >= 2) {
        //         long top1 = st.pop();
        //         long top2 = st.pop();

        //         if (top1 == top2) {
        //             st.push(top1 + top2);
        //         } else {
        //             st.push(top2);
        //             st.push(top1);
        //             break;
        //         }
        //     }
        // }

        // List<Long> res = new ArrayList<>();
        // while (!st.isEmpty()) {
        //     res.add(st.pop());
        // }

        // Collections.reverse(res);
        // return res;
    }
}