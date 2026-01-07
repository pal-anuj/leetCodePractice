// Last updated: 07/01/2026, 23:34:54
1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        
4        Map<Integer, Integer> map= new HashMap<>();
5        for(int i=0;i<nums2.length;i++){
6            map.put(nums2[i], i);
7        }
8
9        int[] res= new int[nums1.length];
10        for(int i=0;i<nums1.length;i++){
11            int j= map.get(nums1[i]);
12            int nextGreater= -1;
13            for(;j<nums2.length;j++){
14                if(nums1[i] < nums2[j]){
15                    nextGreater= nums2[j];
16                    break;
17                }
18            }
19            res[i]= nextGreater;
20        }
21        return res;
22    }
23}