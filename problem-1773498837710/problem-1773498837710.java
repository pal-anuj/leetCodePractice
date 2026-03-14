// Last updated: 14/03/2026, 20:03:57
1class Solution {
2    public int firstUniqueEven(int[] nums) {
3        Map<Integer,Integer> freqCount= new HashMap<>();
4        for(int num : nums)
5            freqCount.put(num, freqCount.getOrDefault(num, 0)+1);
6
7        for(int num : nums){
8            if(num % 2== 0 && freqCount.get(num)==1){
9                return num;
10            }
11        }
12        return -1;
13    }
14}