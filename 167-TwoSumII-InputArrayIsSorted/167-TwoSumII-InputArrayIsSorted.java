// Last updated: 19/03/2026, 23:37:20
1class Solution {
2
3    private void swap(int[] nums, int i, int j) {
4        int temp = nums[i];
5        nums[i] = nums[j];
6        nums[j] = temp;
7    }
8
9    public void sortColors(int[] nums) {
10        // Efficient Approach, timeComplexity O(n) 
11        int low = 0; int mid = 0; int high = nums.length - 1;
12        while (mid <= high) {
13            if (nums[mid] == 0)
14                swap(nums, low++, mid++);
15            else if (nums[mid] == 1)
16                mid++;
17            else
18                swap(nums, mid, high--);
19        }
20
21        // // Brute naive O(2n)
22        // int count0 = 0; int count1 = 0; int count2 = 0;
23        // for (int num : nums) {
24        //     if (num == 0)
25        //         count0++;
26        //     else if (num == 1)
27        //         count1++;
28        //     else if (num == 2)
29        //         count2++;
30        // }
31
32        // int idx = 0;
33        // while (count0-- > 0) nums[idx++] = 0;
34        // while (count1-- > 0) nums[idx++] = 1;
35        // while (count2-- > 0) nums[idx++] = 2;
36
37        // // Brute force approach, TimeComplexity O(n2) 
38        // for (int i = 0; i < nums.length; i++) {
39        //     for (int j = 0; j < nums.length - 1; j++) {
40        //         if (nums[j] > nums[j + 1]) {
41        //             int temp = nums[j];
42        //             nums[j] = nums[j + 1];
43        //             nums[j + 1] = temp;
44        //         }
45        //     }
46        // }
47    }
48}