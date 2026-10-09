// Last updated: 10/10/2026, 01:02:43
1class Solution {
2    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
3        int n = candies.length;
4        int maxCandies = 0;
5        for (int candy : candies) {
6            if (candy > maxCandies) {
7                maxCandies = candy;
8            }
9        }
10
11        List<Boolean> res = new ArrayList<>(n);
12        for (int candy : candies) {
13            res.add(candy + extraCandies >= maxCandies);
14        }
15
16        return res;
17    }
18}