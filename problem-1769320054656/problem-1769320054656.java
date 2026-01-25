// Last updated: 25/01/2026, 11:17:34
1class Solution {
2    public int[] rotateElements(int[] nums, int k) {
3
4        int n = nums.length;
5
6        int[] arr = new int[n];
7        int j = 0;
8        for (int i = 0; i < n; i++) {
9            if (nums[i] >= 0) {
10                arr[j++] = nums[i];
11            }
12        }
13
14        if (j ==0 )
15            return nums;
16        
17        k = k % j;
18        reverse(arr, 0, k - 1);
19        reverse(arr, k, j - 1);
20        reverse(arr, 0, j - 1);
21
22        // for (int num : arr)
23        //     System.out.println(num);
24        // System.out.println("j=" + j + ", k="  +k);
25
26        j = 0;
27        for (int i = 0; i < nums.length; i++) {
28            if (nums[i] >= 0)
29                nums[i] = arr[j++];
30        }
31
32        return nums;
33    }
34
35    public void reverse(int[] arr, int l, int r) {
36
37        while (l < r) {
38            int temp = arr[l];
39            arr[l++] = arr[r];
40            arr[r--] = temp;
41        }
42    }
43}