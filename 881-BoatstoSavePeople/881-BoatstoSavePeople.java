// Last updated: 21/10/2026, 01:05:32
1class Solution {
2    public int numRescueBoats(int[] people, int limit) {
3        Arrays.sort(people);
4        int count = 0;
5        int l = 0;
6        int r = people.length - 1;
7        while (l <= r) {
8            if (people[r] + people[l] <= limit) {
9                l++;
10            }
11            r--;
12            count++;
13        }
14        return count;
15    }
16}