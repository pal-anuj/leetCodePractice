// Last updated: 19/03/2026, 20:24:38
1class Solution {
2    public int removeDuplicates(int[] nums) {
3
4        //Efficient approach
5        int l = 0;
6        l++;
7        for (int r = 1; r < nums.length; r++) {
8            if (nums[r] != nums[r - 1]) {
9                nums[l++] = nums[r];
10            }
11        }
12        return l;
13
14        // // brute Force
15        // if (nums.length == 0) return 0;
16
17        // List<Integer> ls = new ArrayList<>();
18        // ls.add(nums[0]);
19        // for (int i = 1; i < nums.length; i++) {
20        //     if (nums[i] != nums[i - 1])
21        //         ls.add(nums[i]);
22        // }
23
24        // for (int i = 0; i < ls.size(); i++) {
25        //     nums[i] = ls.get(i);
26        // }
27
28        // return ls.size();
29    }
30}