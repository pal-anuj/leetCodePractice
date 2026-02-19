// Last updated: 19/02/2026, 06:37:40
1class Solution {
2    public int subarraySum(int[] nums, int k) {
3        
4        Map<Integer, Integer> map= new HashMap<>();
5        map.put(0,1);
6        int sum=0; int count=0;
7        for(int num : nums){
8            //logic using map
9            sum+= num;
10            count += map.getOrDefault(sum-k, 0);
11            map.put(sum, map.getOrDefault(sum, 0)+1);
12        }        
13        return count;
14
15    }
16}