// Last updated: 11/06/2025, 17:43:42
class Solution {
    public int missingNumber(int[] nums) {
        int arrSize = nums.length;
        int sumOfNaturalNumb = arrSize*(arrSize+1)/2;
        int sum=0;

        for(int i =0; i<arrSize; i++)
        {
            sum = sum + nums[i];

        }
        int missingnum = sumOfNaturalNumb - sum;

        return missingnum;

    }

}