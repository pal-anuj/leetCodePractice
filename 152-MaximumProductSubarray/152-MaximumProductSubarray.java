// Last updated: 01/04/2026, 09:06:00
1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        int[] res = new int[nums1.length];
4        for (int i = 0; i < nums1.length; i++) {
5            int nextgreater = -1;
6            for (int j = 0; j < nums2.length; j++) {
7                if (nums1[i] == nums2[j]) {
8                    for (; j < nums2.length; j++) {
9                        if (nums1[i] < nums2[j]) {
10                            nextgreater = nums2[j];
11                            break;
12                        }
13                    }
14                    break;
15                }
16            }
17            res[i] = nextgreater;
18        }
19        return res;
20    }
21}