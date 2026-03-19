// Last updated: 19/03/2026, 20:13:35
1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3        int[] res = new int[2];
4
5        // Efficient Time- O(logn)
6        int l = 0;
7        int r = numbers.length - 1;
8        while (l < r) {
9            int sum = numbers[l] + numbers[r];
10
11            if (sum < target)
12                l++;
13            else if (sum > target)
14                r--;
15            else {
16                res[0] = l + 1;
17                res[1] = r + 1;
18                return res;
19            }
20        }
21
22        // // Brute force O(n2)
23        // for (int i = 0; i < numbers.length - 1; i++) {
24        //     for (int j = i + 1; j < numbers.length; j++) {
25        //         if (numbers[i] + numbers[j] == target) {
26        //             res[0] = i + 1;
27        //             res[1] = j + 1;
28        //             return res;
29        //         }
30        //     }
31        // }
32
33        return res;
34    }
35}