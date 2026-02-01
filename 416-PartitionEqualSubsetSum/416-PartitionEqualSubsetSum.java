// Last updated: 01/02/2026, 23:25:05
1class Solution {
2
3    // Main function to check if array can be partitioned into two equal-sum subsets
4    public boolean canPartition(int[] nums) {
5
6        // Step 1: Calculate total sum of all elements
7        int sum = 0;
8        for (int num : nums)
9            sum += num;
10
11        // Step 2: If total sum is odd, it cannot be divided into two equal parts
12        if (sum % 2 != 0)
13            return false;
14
15        // Step 3: Otherwise, check if there exists a subset with sum = sum / 2
16        return subsetSum(nums, nums.length, sum / 2);
17    }
18
19    // Function to check if there exists a subset of 'arr'
20    // with sum equal to 'sum'
21    private boolean subsetSum(int[] arr, int n, int sum) {
22
23        // DP table:
24        // t[i][j] = true if we can form sum 'j' using first 'i' elements
25        boolean t[][] = new boolean[n + 1][sum + 1];
26
27        // Step 4: Initialize DP table (base cases)
28        for (int i = 0; i <= n; i++) {
29            for (int j = 0; j <= sum; j++) {
30
31                // If there are 0 elements, we cannot form any positive sum
32                if (i == 0)
33                    t[i][j] = false;
34
35                // If required sum is 0, we can always form it (empty subset)
36                if (j == 0)
37                    t[i][j] = true;
38            }
39        }
40
41        // Step 5: Fill the DP table using 0/1 Knapsack logic
42        for (int i = 1; i <= n; i++) {
43            for (int j = 1; j <= sum; j++) {
44
45                // If current element can be included
46                if (arr[i - 1] <= j) {
47
48                    // Choice:
49                    // 1) Include the element
50                    // 2) Exclude the element
51                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
52
53                } else {
54                    // If element is too big, we cannot include it
55                    t[i][j] = t[i - 1][j];
56                }
57            }
58        }
59
60        // Step 6: Final answer
61        // Can we form sum = sum/2 using all elements?
62        return t[n][sum];
63    }
64}