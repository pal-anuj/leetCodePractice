// Last updated: 19/03/2026, 20:07:20
1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3        int[] res = new int[2];
4
5        for (int i = 0; i < numbers.length - 1; i++) {
6            for (int j = i + 1; j < numbers.length; j++) {
7                if (numbers[i] + numbers[j] == target) {
8                    res[0] = i + 1;
9                    res[1] = j + 1;
10                    return res;
11                }
12            }
13        }
14        return res;
15    }
16}