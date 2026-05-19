// Last updated: 20/05/2026, 00:03:02
1class Solution {
2    public boolean containsDuplicate(int[] nums) {
3        Set<Integer> ls= new HashSet<>();
4        for(int num: nums){
5            if(ls.contains(num))
6                return true;
7            ls.add(num);    
8        }
9        return false;
10    }
11}