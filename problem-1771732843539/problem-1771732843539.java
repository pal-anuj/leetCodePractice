// Last updated: 22/02/2026, 09:30:43
1class Solution {
2    public int scoreDifference(int[] nums) {
3        int score1 = 0;
4        int score2 = 0;
5
6        boolean isPlayer1active = true;
7
8        for (int i = 0; i < nums.length; i++) {
9            if (nums[i] % 2 != 0)
10                isPlayer1active = !isPlayer1active;
11
12            if ((i + 1) % 6 == 0)
13                isPlayer1active = !isPlayer1active;
14
15            if (isPlayer1active)
16                score1 += nums[i];
17            else
18                score2 += nums[i];
19        }
20        return score1 - score2;
21    }
22}