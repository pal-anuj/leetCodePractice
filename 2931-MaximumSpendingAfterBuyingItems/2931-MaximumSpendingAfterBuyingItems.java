// Last updated: 19/06/2026, 20:47:31
1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        int n = nums.length;
4        List<List<Integer>> res = new ArrayList<>();
5        HashSet<List<Integer>> set = new HashSet<>();
6
7        Arrays.sort(nums);
8        for (int i = 0; i < n; i++) {
9            if (i > 0 && nums[i] == nums[i - 1])
10                continue;
11
12            int l = i + 1;
13            int r = n - 1;
14            while (l < r) {
15                int sum = nums[i] + nums[l] + nums[r];
16                if (sum > 0) {
17                    r--;
18                } else if (sum < 0) {
19                    l++;
20                } else {
21                    List<Integer> ls = Arrays.asList(nums[i], nums[l], nums[r]);
22                    Collections.sort(ls);
23                    if (!set.contains(ls)) {
24                        res.add(ls);
25                        set.add(ls);
26                    }
27                    l++;
28                }
29            }
30        }
31        return res;
32    }
33}