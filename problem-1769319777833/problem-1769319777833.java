// Last updated: 25/01/2026, 11:12:57
1class Solution {
2    public int[] rotateElements(int[] nums, int k) {
3
4        int n = nums.length;
5        if (k == 0 || n == 1)
6            return nums;
7
8        int[] arr = new int[n];
9        int j = 0;
10        for (int i = 0; i < n; i++) {
11            if (nums[i] >= 0) {
12                arr[j++] = nums[i];
13            }
14        }
15
16        if (j < 1)
17            return nums;
18        k = k % j;
19
20        reverse(arr, 0, k - 1);
21        reverse(arr, k, j - 1);
22        reverse(arr, 0, j - 1);
23
24        // for (int num : arr)
25        //     System.out.println(num);
26        // System.out.println("j=" + j + ", k="  +k);
27
28        j = 0;
29        for (int i = 0; i < nums.length; i++) {
30            if (nums[i] >= 0)
31                nums[i] = arr[j++];
32        }
33
34        return nums;
35    }
36
37    public void reverse(int[] arr, int l, int r) {
38
39        while (l < r) {
40            int temp = arr[l];
41            arr[l++] = arr[r];
42            arr[r--] = temp;
43        }
44    }
45}