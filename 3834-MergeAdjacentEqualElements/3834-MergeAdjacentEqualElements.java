// Last updated: 08/02/2026, 15:26:54
1class Solution {
2    //[4,1,1,2]
3    public List<Long> mergeAdjacent(int[] nums) {
4
5        Stack<Long> st = new Stack<>();
6        for (int i = 0; i < nums.length; i++) {
7
8            st.push((long) nums[i]);
9            while (st.size() >= 2) {
10                long top1 = st.pop();
11                long top2 = st.pop();
12
13                if (top1 == top2) {
14                    st.push(top1 + top2);
15                } else {
16                    st.push(top2);
17                    st.push(top1);
18                    break;
19                }
20            }
21        }
22
23        List<Long> res = new ArrayList<>();
24        while (!st.isEmpty()) {
25            res.add(st.pop());
26        }
27
28        Collections.reverse(res);
29        return res;
30    }
31}