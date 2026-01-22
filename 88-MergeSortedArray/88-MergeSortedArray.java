// Last updated: 22/01/2026, 09:35:16
1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3
4        int i=m-1;
5        int j=n-1;
6        int k=m+n-1;
7
8        while(j>=0){
9            // if nums1 is exhausted OR nums2[j] is bigger
10            if (i < 0 || nums2[j] > nums1[i]) {
11                nums1[k] = nums2[j];
12                j--;
13            } else {
14                nums1[k] = nums1[i];
15                i--;
16            }
17            k--;
18        }
19    }
20}
21
22//12358->1234
23//467->567