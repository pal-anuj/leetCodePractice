// Last updated: 28/09/2026, 07:13:12
1class Solution {
2    public int rob(int[] nums) {
3        int n = nums.length;
4        List<Integer> ls1 = new ArrayList<>();
5        List<Integer> ls2 = new ArrayList<>();
6
7        for (int i = 0; i < n; i++) {
8            if (i != 0)
9                ls1.add(nums[i]);
10            if (i != n - 1)
11                ls2.add(nums[i]);
12        }
13        if(n==1)
14            return nums[0];
15
16        return Math.max(nonAdjacent(ls1), nonAdjacent(ls2));
17    }
18
19    // non adjacent problem solution
20    public int nonAdjacent(List<Integer> ls) {
21        int n = ls.size();
22        int prev = ls.get(0);
23        int prev2 = 0;
24
25        for (int i = 1; i < n; i++) {
26            int pick = ls.get(i);
27            if (i > 1)
28                pick += prev2;
29            int notPick = prev;
30
31            int cur = Math.max(pick, notPick);
32            prev2 = prev;
33            prev = cur;
34        }
35
36        return prev;
37    }
38}