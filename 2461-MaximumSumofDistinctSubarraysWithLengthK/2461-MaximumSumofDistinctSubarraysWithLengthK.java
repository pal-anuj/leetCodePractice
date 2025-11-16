// Last updated: 16/11/2025, 23:39:19
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum=0;
        long currSum=0;
        HashMap<Integer,Integer> hm= new HashMap<>(k);
        int left=0;
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            currSum += nums[i];
            // System.out.println(currSum);
            if(i - left + 1 >k){
                int rem= nums[left];
                currSum -= rem;
                int f= hm.get(rem);
                if(f==1)
                    hm.remove(rem);
                else
                    hm.put(rem, f-1);

                left++;
            }
            if(i - left+ 1 == k){
                if(hm.size()==k)
                    maxSum= Math.max(maxSum, currSum);
            }
        }
        
        return maxSum;
    }
}