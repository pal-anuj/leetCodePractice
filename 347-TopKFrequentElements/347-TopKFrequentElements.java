// Last updated: 12/10/2026, 00:15:49
1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3
4        HashMap<Integer, Integer> freqCount= new HashMap<>();    
5        for(int num : nums){
6            freqCount.put(num, freqCount.getOrDefault(num, 0)+1);                
7        }
8
9        // Sort HashMap by freq
10        List<Map.Entry<Integer, Integer>> entries= new ArrayList<>(freqCount.entrySet());
11        entries.sort((a,b) -> b.getValue()- a.getValue() );
12        
13        int[] res= new int[k];
14        for(int i=0;i<k;i++){
15            res[i]= entries.get(i).getKey();
16        }
17
18        return res;
19
20    }
21}