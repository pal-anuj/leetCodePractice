// Last updated: 01/04/2026, 09:29:05
1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        // efficient approach Stack + HashMap
4        int[] res = new int[nums1.length];
5        Stack<Integer> st = new Stack<>();
6        Map<Integer, Integer> map = new HashMap<>();
7
8        // Process nums2
9        for (int num : nums2) {
10            while (!st.isEmpty() && st.peek() < num) {
11                map.put(st.pop(), num);
12            }
13            st.push(num);
14        }
15
16        // Remaining elements → no next greater
17        while (!st.isEmpty()) {
18            map.put(st.pop(), -1);
19        }
20
21        // Build result
22        for (int i = 0; i < nums1.length; i++) {
23            res[i] = map.get(nums1[i]);
24        }
25
26        // // brute force O(n * m)
27        // Map<Integer, Integer> map = new HashMap<>();
28        // for (int i = 0; i < nums2.length; i++) {
29        //     map.put(nums2[i], i);
30        // }
31
32        // for (int i = 0; i < nums1.length; i++) {
33        //     int j = map.get(nums1[i]);
34        //     int nextgreater = -1;
35        //     for (; j < nums2.length; j++) {
36        //         if (nums1[i] < nums2[j]) {
37        //             nextgreater = nums2[j];
38        //             break;
39        //         }
40        //     }
41        //     res[i] = nextgreater;
42        // }
43        return res;
44    }
45}