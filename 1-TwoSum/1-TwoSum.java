// Last updated: 20/05/2026, 00:00:03
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        int n = nums.length;
4        Map<Integer,Integer> map= new HashMap<>();
5        int[] res= new int[2];
6        map.put(nums[0], 0);
7        for(int i=1;i<n;i++){
8            int num= target - nums[i];
9            if(map.containsKey(num))
10                return new int[]{map.get(num), i};
11            map.put(nums[i], i);
12        }
13
14        return res;
15    }
16}