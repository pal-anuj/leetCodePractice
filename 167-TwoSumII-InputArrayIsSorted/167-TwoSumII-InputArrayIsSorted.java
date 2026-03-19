// Last updated: 19/03/2026, 20:20:43
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if (nums.length == 0)
4            return 0;
5
6        List<Integer> ls = new ArrayList<>();
7        ls.add(nums[0]);
8        for (int i = 1; i < nums.length; i++) {
9            if (nums[i] != nums[i - 1])
10                ls.add(nums[i]);
11        }
12
13        for (int i = 0; i < ls.size(); i++) {
14            nums[i] = ls.get(i);
15        }
16
17        return ls.size();
18    }
19}