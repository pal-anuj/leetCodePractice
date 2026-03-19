// Last updated: 19/03/2026, 23:30:57
1class Solution {
2    public void sortColors(int[] nums) {
3        // Efficient Approach
4
5        // Brute naive
6        int count0 = 0;
7        int count1 = 0;
8        int count2 = 0;
9        for (int num : nums) {
10            if (num == 0)
11                count0++;
12            else if (num == 1)
13                count1++;
14            else if (num == 2)
15                count2++;
16        }
17
18        int idx = 0;
19        while (count0-- > 0) nums[idx++] = 0;
20        while (count1-- > 0) nums[idx++] = 1;
21        while (count2-- > 0) nums[idx++] = 2;
22
23        // // Brute force approach, TimeComplexity O(n2) 
24        // for (int i = 0; i < nums.length; i++) {
25        //     for (int j = 0; j < nums.length - 1; j++) {
26        //         if (nums[j] > nums[j + 1]) {
27        //             int temp = nums[j];
28        //             nums[j] = nums[j + 1];
29        //             nums[j + 1] = temp;
30        //         }
31        //     }
32        // }
33    }
34}