// Last updated: 09/01/2026, 01:06:27
1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3
4        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
5        Stack<Integer> stack = new Stack<>();
6
7        // Process nums2
8        for (int num : nums2) {
9            while (!stack.isEmpty() && stack.peek() < num) {
10                nextGreaterMap.put(stack.pop(), num);
11            }
12            stack.push(num);
13        }
14
15        // Remaining elements have no next greater
16        while (!stack.isEmpty()) {
17            nextGreaterMap.put(stack.pop(), -1);
18        }
19
20        // Build result for nums1
21        int[] result = new int[nums1.length];
22        for (int i = 0; i < nums1.length; i++) {
23            result[i] = nextGreaterMap.get(nums1[i]);
24        }
25
26        return result;
27    }
28}