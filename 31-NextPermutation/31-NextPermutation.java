// Last updated: 25/01/2026, 22:26:21
1class Solution {
2    public void nextPermutation(int[] nums) {
3        int n= nums.length;
4        
5        int pivot= -1;
6        for(int i=n-2;i >= 0;i--){
7            if(nums[i] < nums[i+1]){
8                pivot=i;
9                break;
10            }
11        }
12
13        if(pivot== -1){
14            reverse(nums, 0, n-1);
15            return;
16        }
17
18        for(int i= n - 1 ; i > pivot; i--){
19            if(nums[i] > nums[pivot]){
20                swap(nums, i, pivot);
21                break;
22            }
23        }
24
25        reverse(nums, pivot+1, n-1);
26    }
27
28    public void swap(int[] nums, int i, int j){
29        int temp= nums[i];
30        nums[i]= nums[j];
31        nums[j]= temp;
32    }
33
34
35    public void reverse(int[] nums, int start, int end){
36        while (start < end) {
37            swap(nums, start++, end--);
38        }
39    }
40}