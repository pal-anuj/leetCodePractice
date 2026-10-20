// Last updated: 21/10/2026, 01:04:36
1class Solution {
2    public int numRescueBoats(int[] people, int limit) {
3        Arrays.sort(people);
4        int count = 0;
5        int boatW = 0;
6        int l = 0;
7        int r = people.length - 1;
8        while (l <= r) {
9            if (people[r] + people[l] <= limit) {
10                r--;
11                l++;
12            } else if (people[r] <= limit) {
13                r--;
14            }
15            count++;
16        }
17        return count;
18    }
19}