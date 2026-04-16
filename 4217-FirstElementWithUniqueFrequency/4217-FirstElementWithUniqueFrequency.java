// Last updated: 16/04/2026, 05:36:29
class Solution {
    public int firstUniqueFreq(int[] nums) {
        int n = nums.length;

        Set<Integer> count = new HashSet<>();
        Map<Integer,Integer> freqMap= new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        Map<Integer,Integer> freqCount= new HashMap<>();
        for(int freq : freqMap.values()){
            freqCount.put( freq, freqCount.getOrDefault(freq, 0)+1);
        }

        Set<Integer> seen= new HashSet<>();
        for(int num : nums){
            if(!seen.contains(num)){
                seen.add(num);
                int freq= freqMap.get(num);
                if(freqCount.get(freq)==1)
                    return num;
            }
        }
        return -1;
    }
}