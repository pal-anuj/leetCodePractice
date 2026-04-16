// Last updated: 16/04/2026, 05:36:20
class Solution {
    public boolean uniformArray(int[] nums1) {
        int oddCount=0;
        int evenCount=0;
        for(int num : nums1){
            if((num % 2) == 0)
                evenCount++;
            else
                oddCount++;
        }
        return true;
    }
}