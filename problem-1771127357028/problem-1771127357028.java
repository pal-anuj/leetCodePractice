// Last updated: 15/02/2026, 09:19:17
1class Solution {
2    public int firstUniqueFreq(int[] nums) {
3        int n = nums.length;
4
5        Set<Integer> count = new HashSet<>();
6        Map<Integer,Integer> freqMap= new HashMap<>();
7        for (int num : nums) {
8            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
9        }
10
11        Map<Integer,Integer> freqCount= new HashMap<>();
12        for(int freq : freqMap.values()){
13            freqCount.put( freq, freqCount.getOrDefault(freq, 0)+1);
14        }
15
16        Set<Integer> seen= new HashSet<>();
17        for(int num : nums){
18            if(!seen.contains(num)){
19                seen.add(num);
20                int freq= freqMap.get(num);
21                if(freqCount.get(freq)==1)
22                    return num;
23            }
24        }
25        return -1;
26    }
27}