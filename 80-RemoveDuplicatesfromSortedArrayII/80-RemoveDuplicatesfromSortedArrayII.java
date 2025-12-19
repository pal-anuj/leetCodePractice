// Last updated: 19/12/2025, 06:20:11
1class Solution {
2    public int removeDuplicates(int[] arr) {
3        if(arr.length <= 2) return arr.length;
4
5        int slow=2;
6        for (int fast = 2; fast < arr.length; fast++) {
7            // logic
8            if(arr[fast] != arr[ slow - 2 ]){
9                arr[slow]= arr[fast];
10                slow++;   
11            }
12        }
13        return slow;
14    }
15}