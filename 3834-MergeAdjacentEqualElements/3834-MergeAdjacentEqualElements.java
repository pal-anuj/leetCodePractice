// Last updated: 10/02/2026, 00:11:37
1class Solution {
2    //[4,1,1,2]
3    public List<Long> mergeAdjacent(int[] nums) {
4
5        Stack<Long> st = new Stack<>();
6
7        for (int ele : nums) {
8            long num = ele;
9            while (!st.isEmpty() && st.peek() == num) {
10                st.pop();
11                num += num;
12            }
13            st.push(num);
14        }
15        List<Long> ans = new ArrayList<>();
16        for (int i = 0; i < st.size(); i++) {
17            ans.add(st.get(i));
18        }
19        return ans;
20
21        // for (int i = 0; i < nums.length; i++) {
22
23        //     st.push((long) nums[i]);
24        //     while (st.size() >= 2) {
25        //         long top1 = st.pop();
26        //         long top2 = st.pop();
27
28        //         if (top1 == top2) {
29        //             st.push(top1 + top2);
30        //         } else {
31        //             st.push(top2);
32        //             st.push(top1);
33        //             break;
34        //         }
35        //     }
36        // }
37
38        // List<Long> res = new ArrayList<>();
39        // while (!st.isEmpty()) {
40        //     res.add(st.pop());
41        // }
42
43        // Collections.reverse(res);
44        // return res;
45    }
46}