// Last updated: 25/01/2026, 22:28:33
1class Solution {
2    public void nextPermutation(int[] nums) {
3        int n= nums.length;
4        
5        // Find the pivot index        
6        int pivot= -1;
7        for(int i=n-2;i >= 0;i--){
8            if(nums[i] < nums[i+1]){
9                pivot=i;
10                break;
11            }
12        }
13
14        // If pivot point does not exist, 
15        // reverse the whole array
16        if(pivot== -1){
17            reverse(nums, 0, n-1);
18            return;
19        }
20
21        // Find the element from the right 
22        // that is greater than pivot
23        for(int i= n - 1 ; i > pivot; i--){
24            if(nums[i] > nums[pivot]){
25                swap(nums, i, pivot);
26                break;
27            }
28        }
29
30        // Reverse the elements from pivot + 1 to the end
31        reverse(nums, pivot+1, n-1);
32    }
33
34    // helper method for swapping
35    public void swap(int[] nums, int i, int j){
36        int temp= nums[i];
37        nums[i]= nums[j];
38        nums[j]= temp;
39    }
40
41    // helper method for reverse
42    public void reverse(int[] nums, int start, int end){
43        while (start < end) {
44            swap(nums, start++, end--);
45        }
46    }
47}