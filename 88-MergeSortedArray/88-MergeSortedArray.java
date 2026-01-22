// Last updated: 22/01/2026, 20:06:01
1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3
4        int i = m - 1;
5        int j = n - 1;
6        int k = m + n - 1;
7
8        while (j >= 0) {
9            if (i < 0 || nums2[j] > nums1[i]) {
10                nums1[k--] = nums2[j--];
11            } else {
12                nums1[k--] = nums1[i--];
13            }
14        }
15    }
16}