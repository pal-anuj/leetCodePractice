// Last updated: 28/05/2026, 11:38:05
1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int n1 = nums1.length;
4        int n2 = nums2.length;
5
6        if (n1 > n2) {
7            return findMedianSortedArrays(nums2, nums1);
8        }
9        int low = 0; int high = n1;
10        int left = (n1 + n2 + 1) / 2;
11        int n = n1 + n2;
12        while (low <= high) {
13            int mid1 = (low + high) / 2;
14            int mid2 = left - mid1;
15            int l1 = Integer.MIN_VALUE; int l2 = Integer.MIN_VALUE;
16            int r1 = Integer.MAX_VALUE; int r2 = Integer.MAX_VALUE;
17
18            if (mid1 < n1) r1 = nums1[mid1];
19            if (mid2 < n2) r2 = nums2[mid2];
20            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
21            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];
22
23            if (l1 <= r2 && l2 <= r1) {
24                if (n % 2 == 1)
25                    return Math.max(l1, l2);
26                else
27                    return (double) ((Math.max(l1, l2) + Math.min(r1, r2)) / 2.0);
28            } 
29            else if (l1 > r2)
30                high = mid1 - 1;
31            else
32                low = mid1 + 1;
33        }
34        return 0; // program never will reach here so returning dummy value;
35
36        // brute force O(n)
37        // int j = 0;
38        // int[] mergeArr = new int[m + n];
39        // int i = 0;
40        // int k = 0;
41        // while (i < m && j < n && (k < (m + n))) {
42        //     if (nums1[i] <= nums2[j]) {
43        //         mergeArr[k++] = nums1[i++];
44        //     } else {
45        //         mergeArr[k++] = nums2[j++];
46        //     }
47        // }
48
49        // while (i < m && k < (m + n)) {
50        //     mergeArr[k++] = nums1[i++];
51        // }
52
53        // while (j < n && k < (m + n)) {
54        //     mergeArr[k++] = nums2[j++];
55        // }
56
57        // // for(int num : mergeArr){
58        // //     System.out.println(num);            
59        // // }
60
61        // double res = 0;
62        // int mid = (m + n);
63        // System.out.println("Initiial mid="+mid);
64        // if (mid % 2 == 0) {
65        //     mid = (int) Math.floor(mid / 2);
66        //     // System.out.println("mid="+mid);
67        //     // System.out.println(mergeArr[mid-1]);
68        //     // System.out.println(mergeArr[mid]);            
69        //     res = (double) (mergeArr[mid - 1] + mergeArr[mid]) / 2;
70        // } else {
71        //     mid = mid / 2;
72        //     res = mergeArr[mid];
73        // }
74        // return res;
75    }
76}