// Last updated: 16/04/2026, 05:36:22
class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for(int num : nums2)
            map.put(num, map.getOrDefault(num, 0) - 1);

        int swap=0;
        for(int v : map.values()){
            if(Math.abs(v) % 2 != 0)
                return -1;

            swap += Math.abs(v) / 2;
        }
        return swap / 2;
    }
}