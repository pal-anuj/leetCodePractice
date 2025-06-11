// Last updated: 11/06/2025, 17:43:54
class Solution {
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high)
        {
            if(nums[mid]==0){
                swap(nums, low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                swap(nums, mid, high);
                  //  mid++;
                    high--;
            }
        }    
    }

    public void swap(int[] nums,int low, int high)
    {
        int temp=nums[low];
        nums[low]=nums[high];
        nums[high]=temp;
    }

}