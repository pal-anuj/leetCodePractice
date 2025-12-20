// Last updated: 20/12/2025, 19:35:00
1class Solution {
2    public int findDuplicate(int[] arr) {
3        //using extra space
4        HashSet<Integer> hs= new HashSet<>();
5        for(int i=0;i<arr.length;i++){
6            if(hs.contains(arr[i]))
7                return arr[i];
8            else
9                hs.add(arr[i]);
10        }
11        return 0;
12    }
13}