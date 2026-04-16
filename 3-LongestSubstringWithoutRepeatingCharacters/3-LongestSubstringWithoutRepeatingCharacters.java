// Last updated: 16/04/2026, 05:35:03
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longest = 0;

        for(int num:set){
            if(!set.contains(num - 1)){
                int curr = num;
                int count = 1;
            while(set.contains(curr + 1)){
                curr++;
                count++;
            }
            longest =  Math.max(longest,count);
        }
        }
        return longest;
    }
}