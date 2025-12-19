// Last updated: 19/12/2025, 06:28:57
1class Solution {
2    public int majorityElement(int[] nums) {
3
4        int count=1;
5        int res=0;
6        for(int i=1;i<nums.length;i++){
7            if(nums[res]==nums[i])
8                count++;
9            else{
10                count--;
11                if(count==0){
12                    res=i;
13                    count=1;
14                }
15            }    
16        }
17
18        count=0;
19        for(int i=0;i<nums.length;i++){
20            if(nums[res]==nums[i])
21                count++;
22        }
23         
24        if(count <= nums.length/2) return -1; 
25        return nums[res];
26    }
27}