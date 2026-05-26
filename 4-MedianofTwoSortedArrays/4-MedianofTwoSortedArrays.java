// Last updated: 26/05/2026, 10:18:53
1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int m = nums1.length;
4        int n = nums2.length;
5
6        if((m+n)==1){
7            if(m==1)
8                return (double) nums1[0];
9            else
10                return (double) nums2[0];    
11        }
12
13        int j = 0;
14        int[] mergeArr = new int[m + n];
15        int i = 0;
16        int k = 0;
17        while (i < m && j < n && (k < (m + n))) {
18            if (nums1[i] <= nums2[j]) {
19                mergeArr[k++] = nums1[i++];
20            } else {
21                mergeArr[k++] = nums2[j++];
22            }
23        }
24
25        while (i < m && k < (m + n)) {
26            mergeArr[k++] = nums1[i++];
27        }
28
29        while (j < n && k < (m + n)) {
30            mergeArr[k++] = nums2[j++];
31        }
32
33        // for(int num : mergeArr){
34        //     System.out.println(num);            
35        // }
36
37        double res = 0;
38        int mid = (m + n);
39        System.out.println("Initiial mid="+mid);
40        if (mid % 2 == 0) {
41            mid = (int) Math.floor(mid / 2);
42            // System.out.println("mid="+mid);
43            // System.out.println(mergeArr[mid-1]);
44            // System.out.println(mergeArr[mid]);            
45            res = (double) (mergeArr[mid - 1] + mergeArr[mid]) / 2;
46        } else {
47            mid = mid / 2;
48            res = mergeArr[mid];
49        }
50        return res;
51    }
52}