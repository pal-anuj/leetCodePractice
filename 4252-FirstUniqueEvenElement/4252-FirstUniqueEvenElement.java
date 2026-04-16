// Last updated: 16/04/2026, 05:36:23
class Solution {
    public int firstUniqueEven(int[] nums) {
        Map<Integer,Integer> freqCount= new HashMap<>();
        for(int num : nums)
            freqCount.put(num, freqCount.getOrDefault(num, 0)+1);

        for(int num : nums){
            if(num % 2== 0 && freqCount.get(num)==1){
                return num;
            }
        }
        return -1;
    }
}