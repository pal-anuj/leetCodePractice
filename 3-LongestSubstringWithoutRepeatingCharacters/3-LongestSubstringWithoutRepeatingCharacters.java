// Last updated: 16/04/2026, 05:32:30
1class Solution {
2
3    public int longestConsecutive(int[] nums) {
4        Set<Integer> freq = new HashSet<>();
5        for (int num : nums)
6            freq.add(num);
7
8        int longest = 0;
9        for (int num : freq) {
10            int count = 0;
11            if (!freq.contains(num - 1)) {
12                while (freq.contains(num++)) {
13                    count++;
14                    longest = Math.max(longest, count);
15                }
16            }
17        }
18        return longest;
19    }
20}