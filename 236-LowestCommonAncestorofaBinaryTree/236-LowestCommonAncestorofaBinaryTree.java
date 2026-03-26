// Last updated: 27/03/2026, 00:31:39
1class Solution {
2    public int findDuplicate(int[] nums) {
3        // [Head] -> (1) -> (3) -> (4) -> (2) -> (2) -> [NULL]
4        int slow = nums[0];
5        int fast = nums[0];
6
7        do {
8            slow = nums[slow];
9            fast = nums[nums[fast]];
10        } while (slow != fast);
11
12        fast = nums[0];
13        while (slow != fast) {
14            slow = nums[slow];
15            fast = nums[fast];
16        }
17        return slow;
18    }
19}