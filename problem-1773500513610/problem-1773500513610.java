// Last updated: 14/03/2026, 20:31:53
1class Solution {
2    public long gcdSum(int[] nums) {
3        int[] gcdPrefix = gcdPrefix(nums);
4
5        // for(int num : gcdPrefix)
6        //    System.out.println(num);                 
7
8        Arrays.sort(gcdPrefix);
9
10        int l = 0;
11        int r = gcdPrefix.length - 1;
12        long res = 0;
13        while (l < r) {
14            res += gcd(gcdPrefix[l++], gcdPrefix[r--]);
15        }
16        return res;
17    }
18
19    private int[] gcdPrefix(int[] nums) {
20        int n = nums.length;
21        int[] gcdPrefix = new int[n];
22        int runningMax = nums[0];
23        gcdPrefix[0] = gcd(nums[0], runningMax);
24
25        for (int i = 1; i < n; i++) {
26            runningMax = Math.max(nums[i], runningMax);
27            gcdPrefix[i] = gcd(nums[i], runningMax);
28        }
29        return gcdPrefix;
30    }
31
32    private int gcd(int a, int b) {
33        while (b != 0) {
34            int temp = b;
35            b = a % b;
36            a = temp;
37        }
38        return a;
39    }
40}