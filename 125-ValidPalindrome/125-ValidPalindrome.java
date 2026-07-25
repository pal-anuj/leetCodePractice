// Last updated: 25/07/2026, 14:43:03
1class Solution {
2
3    // [-4,-1,-1,0,1,2]
4    public List<List<Integer>> threeSum(int[] nums) {
5        int n = nums.length;
6        Arrays.sort(nums);
7        List<List<Integer>> res = new ArrayList<>();
8        for (int i = 0; i < n - 2; i++) {
9
10            // Skip duplicate first elements
11            if (i > 0 && nums[i] == nums[i - 1]) {
12                continue;
13            }
14            int l = i + 1;
15            int r = n - 1;
16            while (l < r) {
17                int sum = nums[l] + nums[r] + nums[i];
18                if (sum < 0) {
19                    l++;
20                } 
21                else if (sum > 0) {
22                    r--;
23                } 
24                else if (sum == 0) {
25                    List<Integer> ls = new ArrayList<>(Arrays.asList(nums[l], nums[r], nums[i]));
26                    res.add(ls);
27                    l++;
28                    r--;
29
30                    // Skip duplicate left values
31                    while (l < r && nums[l] == nums[l - 1]) {
32                        l++;
33                    }
34
35                    // Skip duplicate right values
36                    while (l < r && nums[r] == nums[r + 1]) {
37                        r--;
38                    }
39                }
40            }
41
42        }
43
44        return res;
45    }
46}