// Last updated: 18/02/2026, 07:46:14
1class NumArray {
2
3    int[] prefix;
4    public NumArray(int[] nums) {
5        prefix= new int[nums.length+1];
6        for(int i=0;i<nums.length;i++)
7            prefix[i+1]= prefix[i] + nums[i]; 
8    }
9    
10    public int sumRange(int left, int right) {
11        return prefix[right+1] - prefix[left];
12    }
13}
14
15/**
16 * Your NumArray object will be instantiated and called as such:
17 * NumArray obj = new NumArray(nums);
18 * int param_1 = obj.sumRange(left,right);
19 */