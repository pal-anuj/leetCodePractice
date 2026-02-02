// Last updated: 02/02/2026, 22:18:47
1class Solution {
2
3    public int coinChange(int[] coins, int amount) {
4        int n = coins.length;
5        int t[][] = new int[n + 1][amount + 1];
6
7        for (int i = 0; i <= n; i++) {
8            for (int j = 0; j <= amount; j++) {
9                if (i == 0)
10                    t[i][j] = Integer.MAX_VALUE - 1;
11                if (j == 0)
12                    t[i][j] = 0;
13            }
14        }
15
16        int i = 1;
17        for (int j = 1; j <= amount; j++) {
18            if (j % coins[0] == 0)
19                t[i][j] = j / coins[0];
20            else
21                t[i][j] = Integer.MAX_VALUE - 1;
22        }
23
24        for (i = 2; i <= n; i++) {
25            for (int j = 1; j <= amount; j++) {
26                if (coins[i - 1] <= j) {
27                    t[i][j] = Math.min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
28                } else
29                    t[i][j] = t[i - 1][j];
30            }
31        }
32
33        return t[n][amount] == Integer.MAX_VALUE - 1 ? -1 : t[n][amount];
34    }
35}