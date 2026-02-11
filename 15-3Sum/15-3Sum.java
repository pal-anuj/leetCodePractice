// Last updated: 11/02/2026, 06:08:32
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }

        List<List<Integer>> rs = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (i != 0 && nums[i] == nums[i - 1])continue;
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0){
                    left++;
                }
                else if (sum > 0){
                    right--;
                }
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    rs.add(temp);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1])left++;
                    while(left < right && nums[right] == nums[right + 1])right--;
                }
            }
        }
        return rs;
    }
}